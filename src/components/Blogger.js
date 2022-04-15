import React, { useEffect } from "react";
import {useState} from "react";

function Blogger()
{
    const[blogs,setBlogs]=useState([])

    useEffect(()=> {
        fetch('http://localhost:8080/allblogs')
        .then(res=>res.json())
        .then(data=>setBlogs(data))
        
    },[]);

    const handleInsert=(e)=>{
        navigate("/saveproduct");
    }

    const handleDelete=(id)=>{
        fetch("http://localhost:8080/deleteblog?bloggerid="+id)
        .then(function(response){
            if(response.ok){
                alert("Deletion Successful");
                navigate("/blogger");
            }         
            else{
                alert("Deletion Failed");
            }
       })
    }

    return (
            <div className="container">
            <form className="container">
            <div style={{backgroundColor:"cadetblue",textAlign:"center",height:"100px"}}>
                <h1><u>BLOGS</u></h1>
            </div><br/>
            <button style={{float:"left"}} className="btn btn-primary" onClick={handleInsert}>Add New Blog</button>
            <br/><br/>
            <div style={{backgroundColor:"aliceblue"}}>
            <table className="table table-bordered table-striped table-active">
                <tr style={{backgroundColor:"coral", height:"50px"}}>
                        <th>Blogger ID</th>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Action</th>
                </tr>
                {
                        blogs.map(
                            (obj)=>{
                                return(
                                    <tr>
                                        <td>{obj.bloggerid}</td>
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