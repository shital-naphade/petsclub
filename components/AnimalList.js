
import {useEffect,useState} from "react";
import {Link, useNavigate} from "react-router-dom";
import React, { useCallback } from 'react';
import mystore from "./store";

function AnimalList(){
     
    let navigate = useNavigate();
    const[count,setCount]=useState(0);
    const[animals,setAnimals]=useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/allanimals")       
        .then(resp=>resp.json())
        .then(data=>setAnimals(data))
      }, []);
    
    const handleInsert=(e)=>{
        navigate("/saveanimal");
    }
    
    const handleUpdate=(obj)=>{
        alert(obj.breed);
        localStorage.setItem("animalupdate",JSON.stringify(obj));
        navigate("/updateanimal")
    }

    const handleDelete=(id)=>{
        alert("in handle del");
        fetch("http://localhost:8080/deleteanimal/"+id)
        .then(function(response){
            if(response.ok){
                alert("Deletion Sucessfully")
                navigate("/animallist");
                //useEffect();
            }         
            else{
                alert("Deletion Failed");
            }
       })
    }
    const logout = (c) => {
        mystore.dispatch({type:'LOGGEDOUT'})
        localStorage.removeItem("loginmanager");
        navigate("/login");
    }
    return (
        <div className='container'>
            <form className="container">
            <a href="#" style={{float:"right"}} onClick={(c) => {logout(c)}}>LOGOUT</a>
            <br/><br/>
            <div style={{backgroundColor:"cadetblue",textAlign:"center",height:"100px"}}>
                <h1><u>Animal List</u></h1>
            </div><br/>
            <button style={{float:"left"}} className="btn btn-primary" onClick={handleInsert}>Add New Animal</button>
            <br/><br/>
            <div style={{backgroundColor:"aliceblue"}}>
            <table className="table table-bordered table-striped table-active">
                <tr style={{backgroundColor:"coral", height:"50px"}}>
                    <th>Breed</th>
                    <th>Breed Description</th>
                    <th>Age</th>
                    <th>Qty</th>
                    <th>Price</th>
                    <th>Certification</th>
                    <th colspan="2">Actions</th>
                </tr>
                    {
                        animals.map(
                            (obj)=>{
                                return(
                                    <tr>
                                        <td>{obj.breed}</td>
                                        <td>{obj.breeddesc}</td>
                                        <td>{obj.age}</td>
                                        <td>{obj.qty}</td>
                                        <td>{obj.price}</td>
                                        <td>{obj.certification}</td>
                                        <td><button className="btn btn-info" onClick={()=>{handleUpdate(obj)}}>UPDATE </button></td>
                                        <td><button className="btn btn-info" onClick={()=>{handleDelete(obj.aid)}}>DELETE</button> </td>
                                        
                                    </tr>
                                )
                            }
                        )
                    }
                </table>
                </div>
                <a href="/managerhome" style={{float:"left"}}>Manager Home Page</a>
            </form>
            
        </div>
    );
    
}
export default AnimalList;