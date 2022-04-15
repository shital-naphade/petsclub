
import {useEffect,useState} from "react";
import {useNavigate} from "react-router-dom";
import mystore from "./store";

function CustomerAnimalList(){
     
    let navigate = useNavigate();
   
    const data=JSON.parse(localStorage.getItem("logincustomer"));

    const[animals,setAnimals]=useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/allanimals")       
        .then(resp=>resp.json())
        .then(data=>setAnimals(data))
      }, []);
    
    const handleInsert=(e)=>{
        const reqData = {
            method: 'POST',
            headers: {'Content-Type':'application/json'},
            body : JSON.stringify({
               
            })
        }
        fetch("http://localhost:8080/viewcart",reqData)
        .then(resp=>resp.json())   
        .then(obj=>{
            localStorage.setItem("localviewcart",JSON.stringify(obj));
           
        });
        navigate("/viewcart");
    }

    const AddToCart=(obj)=>{
     
        //return false;
      
        //obj.preventDefault();
        const reqData = {
            method: 'POST',
            headers: {'Content-Type':'application/json'},
            body : JSON.stringify({
                userid : data.userid,
                aid : obj.aid,
                qty : obj.qty,
                price: obj.price
            })
        }
       
        fetch("http://localhost:8080/addtocart1",reqData)
        .then(function(response){
            if(response.ok){
                navigate("/custanimallist");
            }         
            else{
                alert("custanimallist");
            }
       })
    }
    const logout = (c) => {
        mystore.dispatch({type:'LOGGEDOUT'})
        localStorage.removeItem("logincustomer");
        navigate("/login");
    }

    return (
        <div className='container'>
            <a href="#" style={{float:"right",margin:5 }} onClick={(c) => {logout(c)}}>LOGOUT</a>
            <a href="/customerblogs" style={{float:"right",margin:5 }} >BLOGS</a>
            <br/><br/>
            <form className="container">
            <div style={{backgroundColor:"cadetblue",textAlign:"center",height:"100px"}}>
                <h1><u>Animal List</u></h1>
            </div><br/>
            {/*<button style={{float:"left"}} className="btn btn-primary" onClick={handleInsert}>View Cart</button>
            <br/><br/>*/}
            <div style={{backgroundColor:"aliceblue"}}>
            <table className="table table-bordered table-striped table-active">
                <tr style={{backgroundColor:"coral", height:"50px"}}>
                    <th>Breed</th>
                    <th>Breed Description</th>
                    <th>Age</th>
                    <th>Qty</th>
                    <th>Price</th>
                    <th>Certification</th>
                    <th>Action</th>
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
                                        <td><button className="btn btn-primary" onClick={()=>{AddToCart(obj)}}>Add to Cart</button></td>
                                    </tr>
                                )
                            }
                        )
                    }
                </table>
                </div>
                <a href="/customerhome" style={{float:"left"}}>Customer Home Page</a>
            </form>
           
        </div>
    );
    
}
export default CustomerAnimalList;