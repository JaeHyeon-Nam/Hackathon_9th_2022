import './App.scss';
import {useEffect, useState} from "react";
import Intro from "./components/Intro";
import Header from "./components/Header";
import {useCookies} from "react-cookie";
import Pages from "./components/Pages";
import {useDispatch, useSelector} from "react-redux";
import Shop from "./components/Shop";

function App() {
    let [cookie] = useCookies()
    let shopView = useSelector((state) => state.shopView)
    let [shopType, setShopType] = useState()
    const dispatch = useDispatch()
    return (
        <div className="App">
            <Intro></Intro>
            {
                cookie.id && <Header></Header>
            }
            {
                cookie.id && <Pages setShopType={setShopType}></Pages>
            }
            {
                shopView && <Shop shopType={shopType} setShopType={setShopType}></Shop>
            }
        </div>
    )
}

export default App;
