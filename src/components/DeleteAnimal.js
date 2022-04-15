import {useState} from "react";
import {useNavigate} from "react-router-dom";
import React, { useCallback } from 'react';

function DeleteAnimal(){
    let navigate = useNavigate();
    const[state,setState]=useState({
        breed:"",
        breeddesc:"",
        age :"",
        qty:"",
        price:"",
        certification :""
    });
    let catid = React.createRef();

    const [ProductMaster,setProductMaster] = useState({});
    const handleInput=(event)=>{
       setState((state)=>({
        ...state,
        [event.target.name]:event.target.value
       }))

    }

    const[category,setCategory]=useState({
        allcategory : []
        
    });
    const[CATEGORY,setcatid]=useState({
        catid:''
    });

    React.useEffect(() => {
        fetch("http://localhost:8080/allcategory")  
        .then(resp => resp.json())
        .then(data => setCategory({allcategory : data})) 
      }, []
    );

    const selectCategory = (c) => 
    {     
        setcatid({catid:c.target.value})
    }

    const SubmitData = (evt) => 
    {
        evt.preventDefault(); 
        const reqData = {
            method: 'POST',
            headers: {'Content-Type':'application/json'},
            body : JSON.stringify({
                catid:CATEGORY.catid
            })
        }
        fetch("http://localhost:8080/deleteanimal",reqData)
        .then(function(response){
            if(response.ok){
                alert("Insertion Sucessfull")
                navigate("/managerhome");
            }         
            else{
                alert("Insertion Failed");
                navigate("/deleteanimal");
            }
       })
    }
    return (
        <div className='container'>
            <form  onSubmit={(c) => {SubmitData(c)}}>
                    <table >
                        <tr>
                            <td colspan="2" className='text-warning h2'>Delete Animal</td>
                        </tr><br/>
                        <tr>
                            <td>Select Breed : </td>
                            <td><select name="breed" required onChange={(c) => {selectCategory(c)}}>
                                        <option value="">(Select Breed)</option>
                                        {  
                                            category.allcategory.map((s) => {
                                                return(<option value={s.cid}> {s.catname} </option>)
                                            })
                                        }
                                </select>
                            </td>
                        </tr>
                        <br/>
                        <tr>
                            <td colSpan="2"><input type="submit" value="  Delete  " className="btn-primary btn-block"/></td>
                        </tr>
                    </table>
                </form>
        </div>
    );
    
}
export default DeleteAnimal;