import './App.css';
import React from 'react';
import Home from './containers/Home';
import Header from './components/Header';
import Hero from './components/Hero';
import {BrowserRouter as Router,Switch,Route} from 'react-router-dom';
import ContactUs from './containers/ContactUs';
import Post from './containers/Post';
import Sprint1 from './containers/Sprint1';
import OpenBCIProject from './containers/OpenBCIProject';




function App() {
  return (
      <Router>
        <div className="App">
          <Header/>
          <Hero/>

          <Route path="/" exact component={Home}/>
          <Route path="/contact-us" component={ContactUs}/>
          <Route path="/post" component={Post}/>
          <Route path="/sprint1" component={Sprint1}/>
          <Route path='/openbci-project' component={OpenBCIProject}/>

        </div>
      </Router>
    
  );
}

export default App;
