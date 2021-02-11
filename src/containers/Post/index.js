import React from 'react';
import BlogPost from '../../components/BlogPost';
import SideBar from '../../components/SideBar';
import './style.css';

/**
* @author
* @function Post
**/

const Post = (props) => {
  return(
    <section className='container'>
      <BlogPost/>
      <SideBar/>
    </section>
   )

 }

export default Post;