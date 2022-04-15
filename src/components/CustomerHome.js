import React, { useCallback } from 'react';
import { Link } from "react-router-dom";
import mystore from "./store";
import {useNavigate} from "react-router-dom";

function CustomerHome(){
    let navigate = useNavigate();
    const data=JSON.parse(localStorage.getItem("logincustomer"))

    const logout = (c) => {
        mystore.dispatch({type:'LOGGEDOUT'})
        localStorage.removeItem("logincustomer");
        navigate("/login");
    }

    return(
        
        <div className='container'>
            
            <a href="#" style={{float:"right"}} onClick={(c) => {logout(c)}}>LOGOUT</a>
            <br/><br/>
            <h2>Welcome to Customer component</h2>
            <ul>
                <br/><br/>
                <Link className="nav-link" to="/custproductlist">All Available Products</Link>
                <Link className="nav-link" to="/custanimallist" >All Available Animals</Link>
            </ul>
        </div>
    );
}
export default CustomerHome;