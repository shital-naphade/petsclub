import React, { useEffect } from "react";
import {useState} from "react";
import {useNavigate} from "react-router-dom";

function CustomerBlogs()
{
    let navigate = useNavigate();
    const[blogs,setBlogs]=useState([])

    useEffect(()=> {
        fetch('http://localhost:8080/allblogs')
        .then(res=>res.json())
        .then(data=>setBlogs(data))
        
    },[]);

    return (
            <div className="container">
            <form className="container">
            <div style={{backgroundColor:"cadetblue",textAlign:"center",height:"100px"}}>
                <h1><u>BLOGS</u></h1>
            </div><br/>
            <div style={{backgroundColor:"aliceblue"}}>
            <table className="table table-bordered table-striped table-active">
                <tr style={{backgroundColor:"coral", height:"50px"}}>
                        <th>Title</th>
                        <th>Description</th>
                </tr>
                {
                        blogs.map(
                            (obj)=>{
                                return(
                                    <tr style={{textAlign:"left" ,height:"100px"}}>
                                        <td>{obj.title}</td>
                                        <td> {obj.description} </td>   
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
export default CustomerBlogs;