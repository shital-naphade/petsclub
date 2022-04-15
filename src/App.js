import logo from './logo.svg';
import './App.css';
import { BrowserRouter,Link,Route,Routes } from 'react-router-dom';
import Welcome from './components/Welcome';
import Login from './components/Login';
import Register from './components/Register';
import ManagerHome from './components/ManagerHome';
import MainMenu from './components/MainMenu'; 
import CustomerHome from './components/CustomerHome';
import Registration from './components/Registration';
import SaveProduct from './components/SaveProduct';
import SaveBlog from './components/SaveBlog';
import Blogger from './components/Blogger';
import SaveAnimal from './components/SaveAnimal';
import DeleteAnimal from './components/DeleteAnimal';
import ProductList from './components/ProductList';
import AnimalList from './components/AnimalList';
import UpdateProduct from './components/UpdateProduct';
import UpdateAnimal from './components/UpdateAnimal';
import CustomerProductList from './components/CustomerProductList';
import CustomerAnimalList from './components/CustomerAnimalList';
import ViewCart from './components/ViewCart';
function App() {
  return (
    <div className="App">
      {/*
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
      <Welcome />
      */}
      <div >
          <BrowserRouter >
            <ul className="nav nav-tabs container">
                <li className="nav-item"><Link className="nav-link" to="/login">LOGIN</Link></li>
                <li className="nav-item"><Link className="nav-link" to="/register">REGISTER</Link></li>
                <li className="nav-item"><Link className="nav-link" to="/blogger">BLOG</Link></li>
            </ul>
            <Routes>              
              <Route path="/menu" element={ <MainMenu  /> } />
              <Route path="/login" element={ <Login  /> } />
              <Route path="/register" element={ <Registration  /> } />
              <Route path="/managerhome" element={ <ManagerHome/> } />
              <Route path="/customerhome" element={ <CustomerHome/> } />
              <Route path="/saveproduct" element={ <SaveProduct/> } />
              <Route path="/blogger" element={ <Blogger/> } />
              <Route path="/saveanimal" element={ <SaveAnimal /> } />
              <Route path="/deleteanimal" element={ <DeleteAnimal /> } />
              <Route path="/productlist" element={ <ProductList /> } />
              <Route path="/animallist" element={ <AnimalList/> } />
              <Route path="/updateproduct" element={ <UpdateProduct/> } />
              <Route path="/updateanimal" element={ <UpdateAnimal/> } />
              <Route path="/custproductlist" element={ <CustomerProductList/> } />
              <Route path="/custanimallist" element={ <CustomerAnimalList/> } />
              <Route path="/viewcart" element={ <ViewCart/> } />
              
            </Routes>
          
          </BrowserRouter>
          
      </div>
      
    </div>
  );
}

export default App;
