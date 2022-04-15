import {useEffect,useState} from "react";
import {useNavigate} from "react-router-dom";

function CustomerProductList (){
    let navigate = useNavigate();
   
    const data=JSON.parse(localStorage.getItem("logincustomer"));

    const[products,setProducts]=useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/allproducts")       
        .then(resp=>resp.json())
        .then(data=>setProducts(data))
      }, []);
    
    const handleInsert=(e)=>{
        alert("in View cart");
        navigate("/viewcart");
    }

    const AddToCart=(obj)=>{
        alert(obj.breed);
        alert(data.userid);
        return false;
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
        alert(obj.price)
        //fetch("http://localhost:8080/addanimaltocart?userid="+data.userid+"&aid="+obj.aid+"&qty="+obj.qty+"&price="+obj.price,reqData)
        fetch("http://localhost:8080/addanimaltocart",reqData)
        .then(function(response){
            if(response.ok){
                alert(obj.price)
                alert("Deletion Sucessfully")
                navigate("/animallist");
                //useEffect();
            }         
            else{
                alert(obj.price)
                alert("Deletion Failed");
            }
       })
    }
    return (
        <div className='container'>
            <form className="container">
            <div style={{backgroundColor:"cadetblue",textAlign:"center",height:"100px"}}>
                <h1><u>Products List</u></h1>
            </div><br/>
            <button style={{float:"left"}} className="btn btn-primary" onClick={handleInsert}>View Cart</button>
            <br/><br/>
            <div style={{backgroundColor:"aliceblue"}}>
            <table className="table table-bordered table-striped table-active">
                <tr style={{backgroundColor:"coral", height:"50px"}}>
                <th>Product Name</th>
                    <th>Produc Description</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Actions</th>
                </tr>
                    {
                        products.map(
                            (obj)=>{
                                return(
                                    <tr>
                                        <td>{obj.productname}</td>
                                        <td>{obj.productdesc}</td>
                                        <td>{obj.qty}</td>
                                        <td>{obj.price}</td>
                                        <td><button className="btn btn-primary" onClick={()=>{AddToCart(obj)}}>Add to Cart</button></td>
                                    </tr>
                                )
                            }
                        )
                    }
                </table>
                </div>
                <a href="/customerhome" style={{float:"left"}}>Home</a>
            </form>
           
        </div>
    );
    
}

export default CustomerProductList;