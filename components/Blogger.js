import React, { useEffect } from "react";
import {useState} from "react";
import {useNavigate} from "react-router-dom";
import mystore from "./store";

function Blogger()
{
    let navigate = useNavigate();
    const[blogs,setBlogs]=useState([])

    useEffect(()=> {
        fetch('http://localhost:8080/allblogs')
        .then(res=>res.json())
        .then(data=>setBlogs(data))
        
    },[]);

    const handleInsert=(e)=>{
        navigate("/saveblog");
    }

    const handleDelete=(id)=>{
        fetch("http://localhost:8080/deleteblog?bloggerid="+id)
        .then(function(response){
            if(response.ok){
                navigate("/blogger");
            }         
            else{
                alert("Deletion Failed");
            }
       })
    }

    const logout = (c) => {
        mystore.dispatch({type:'LOGGEDOUT'})
        localStorage.removeItem("loginblogger");
        navigate("/login");
    }

    return (
            <div className="container">
            <a href="#" style={{float:"right"}} onClick={(c) => {logout(c)}}>LOGOUT</a>
            <br/><br/>
            <form className="container">
            <div style={{backgroundColor:"cadetblue",textAlign:"center",height:"100px"}}>
                <h1><u>BLOGS</u></h1>
            </div><br/>
            <button style={{float:"left"}} className="btn btn-primary" onClick={handleInsert}>Add New Blog</button>
            <br/><br/>
            <div style={{backgroundColor:"aliceblue"}}>
            <table className="table table-bordered table-striped table-active">
                <tr style={{backgroundColor:"coral", height:"50px"}}>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Action</th>
                </tr>
                {
                        blogs.map(
                            (obj)=>{
                                return(
                                    <tr style={{textAlign:"left" ,height:"100px"}}>
                                        <td>{obj.title}</td>
                                        <td> {obj.description} </td>   
                                        <td><button className="btn btn-info" onClick={()=>{handleDelete(obj.bloggerid)}}>DELETE</button> </td>
                                    </tr>
                                )
                            }
                        )
                    }
            </table>
            </div>
           </form>
           
        </div>
    )

}
export default Blogger;