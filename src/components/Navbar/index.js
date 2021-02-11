import React, {useState} from 'react';
import'./style.css';
import  logo from '../../assests/icons/search.png';
import {NavLink} from 'react-router-dom';

/**
* @author
* @function Navbar
**/



const Navbar = (props) => {
  
  const [search, setSearch] = useState(false);


  const submitSearch = (e)=>{
    e.preventDefault();
    alert("Searched");
  }

  const openSearch = ()=>{
    setSearch(true);
  }

  const searchClass = search?'searchInput active':'searchInput';
  
  return(
    <div className="navbar">
        <ul className="navbarMenu">
            <li><NavLink to="/">Home</NavLink></li>
            <li><NavLink to="/openbci-project">OpenBCI Project</NavLink></li>
            <li><NavLink to='/post'>Project Description</NavLink></li>
        </ul>
        <div className="search">
          <form className="searchForm" onSubmit={submitSearch}>
            <input type="text" className={searchClass} placeholder="Search" />
            <img onClick={openSearch} className="searchIcon" src={logo} />
          </form>
        </div>
    </div>

   )

 }

export default Navbar;