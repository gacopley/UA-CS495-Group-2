package com.example.testdatastream;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements
        OnChartValueSelectedListener {
    private LineChart chart;
    Random rand;
    float maxY = 300;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         rand = new Random();


        chart = findViewById(R.id.chart1);
        chart.setOnChartValueSelectedListener(this);

        // enable description text
        chart.getDescription().setEnabled(true);

        // enable touch gestures
        chart.setTouchEnabled(true);

        // enable scaling and dragging
        chart.setDragEnabled(true);
        chart.setScaleEnabled(true);
        chart.setDrawGridBackground(false);

        // if disabled, scaling can be done on x- and y-axis separately
        chart.setPinchZoom(true);

        chart.setVisibleYRangeMaximum(10, YAxis.AxisDependency.LEFT);

        // set an alternative background color
        chart.setBackgroundColor(Color.WHITE);

        LineData data = new LineData();
        data.setValueTextColor(Color.BLACK);

        // add empty data
        chart.setData(data);

        // get the legend (only possible after setting data)
        chart.getLegend().setEnabled(false);

        XAxis xl = chart.getXAxis();
        xl.setTextColor(Color.BLACK);
        xl.setDrawGridLines(false);
        xl.setAvoidFirstLastClipping(true);
        xl.setEnabled(true);

        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setTextColor(Color.BLACK);
        leftAxis.setAxisMaximum(150f);
        leftAxis.setAxisMinimum(0f);
        leftAxis.setDrawGridLines(true);

        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setEnabled(false);
    }

    private void addEntry(String[] vals) {

        LineData data = chart.getData();

        if (data != null) {
            if(count>120){
                maxY = 300;
            }
            else count++;
            for(int i = 0; i<5; i++) {
                LineDataSet set = (LineDataSet) data.getDataSetByIndex(i);
                // set.addEntry(...); // can be called as well

                if (set == null) {
                   set = createSet(i);
                   data.addDataSet(set);
                }
                float val = Float.parseFloat(vals[i]);
                if(set.getEntryCount()>120){
                    try {
                        for (int x = set.getEntryCount() - 120; x < set.getEntryCount(); x++) {
                            maxY = Math.max(set.getEntryForIndex(x).getY(), maxY);
                        }
                    }catch(Exception e){}
                }
                else maxY = Math.max(maxY, val);
              data.addEntry(new Entry(set.getEntryCount(),val) , i);
            }
            YAxis leftAxis = chart.getAxisLeft();
            leftAxis.setTextColor(Color.BLACK);
            leftAxis.setAxisMaximum(maxY);
            //leftAxis.setSpaceTop(0);
            data.notifyDataChanged();

            // let the chart know it's data has changed
            chart.notifyDataSetChanged();

            // limit the number of visible entries
            chart.setVisibleXRangeMaximum(120);

            // chart.setVisibleYRange(30, AxisDependency.LEFT);

            // move to the latest entry
            chart.moveViewToX(data.getEntryCount());

            // this automatically refreshes the chart (calls invalidate())
            // chart.moveViewTo(data.getXValCount()-7, 55f,
            // AxisDependency.LEFT);
        }
    }

    private LineDataSet createSet(int num) {

        LineDataSet set = new LineDataSet(null, "Bandpower - Channel "+num);
        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        int c = Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
        set.setColor(c);
        if(num==0){
            TextView textElement = (TextView) findViewById(R.id.ptDelta);
            textElement.setTextColor(c);
        }
        if(num==1){
            TextView textElement = (TextView) findViewById(R.id.ptTheta);
            textElement.setTextColor(c);
        }
        if(num==2){
            TextView textElement = (TextView) findViewById(R.id.ptAlpha);
            textElement.setTextColor(c);
        }
        if(num==3){
            TextView textElement = (TextView) findViewById(R.id.ptBeta);
            textElement.setTextColor(c);
        }
        if(num==4){
            TextView textElement = (TextView) findViewById(R.id.ptGamma);
            textElement.setTextColor(c);
        }
        set.setCircleColor(c);
        set.setLineWidth(2f);
        set.setFillAlpha(65);
        set.setFillColor(c);
        set.setHighLightColor(c);
        set.setValueTextColor(c);
        set.setValueTextSize(9f);
        set.setDrawValues(false);
        return set;
    }

    private Thread thread;

    private void feedMultiple() {

        if (thread != null)
            thread.interrupt();

        thread = new Thread(new Runnable() {

            @Override
            public void run() {
                DatagramSocket ds = null;
                try {
                    ds = new DatagramSocket(7100);
                    //ds.connect(InetAddress.getByName("192.168.56.1"), 7000);
                } catch (SocketException e) {
                    e.printStackTrace();
                }
                byte[] receive = new byte[65535];

                DatagramPacket DpReceive = null;
                while(true) {

                    try{
                    // Step 2 : create a DatgramPacket to receive the data.
                    DpReceive = new DatagramPacket(receive, receive.length);

                    // Step 3 : revieve the data in byte buffer.
                    try {
                        ds.receive(DpReceive);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String s1 = data(receive).toString();
                    String[] ss = s1.replace("[", "").replace("]", "").replace("}", "").replace("\r\n", "").split(":")[2].split(",");
                        //float val = Float.parseFloat(s1.replace("[", "").split(":")[2].split(",")[1]);
                        //float val1 = Float.parseFloat(s1.replace("[", "").split(":")[2].split(",")[2]);
                        //System.out.println(val);
                        addEntry(ss);
                    }
                    catch(Exception ex){}
                }

            }
        });

        thread.start();
    }

    public static StringBuilder data(byte[] a)
    {
        if (a == null)
            return null;
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0)
        {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }

    @Override
    protected void onStart()
    {
        // TODO Auto-generated method stub
        super.onStart();
        feedMultiple();
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {
        Log.i("Entry selected", e.toString());
    }

    @Override
    public void onNothingSelected() {
        Log.i("Nothing selected", "Nothing selected.");
    }
}