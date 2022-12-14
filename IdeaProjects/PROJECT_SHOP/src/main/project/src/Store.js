import {configureStore, createSlice} from '@reduxjs/toolkit'

let isLogin = createSlice({
    name: 'isLogin',
    initialState : false,
    reducers : {
        setIsLogin(state) {
            return !state
        }
    }
})

let isJoin = createSlice({
    name: 'isJoin',
    initialState : false,
    reducers : {
        setIsJoin(state) {
            return !state
        }
    }
})

let shopView = createSlice({
    name: 'shopView',
    initialState : false,
    reducers : {
        setShopView(state) {
            return !state
        }
    }
})

export default configureStore({
    reducer: {
        isLogin : isLogin.reducer,
        isJoin : isJoin.reducer,
        shopView : shopView.reducer
    }
})

export let { setIsLogin } = isLogin.actions
export let { setIsJoin } = isJoin.actions
export let { setShopView } = shopView.actions