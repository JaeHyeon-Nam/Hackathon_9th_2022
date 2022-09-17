import '../styles/Login.scss'
import {useCookies} from "react-cookie";
import {useEffect} from "react";

export default function Login(props) {
    const user = ['admin','admin']
    const [cookies,setCookie] = useCookies()

    useEffect(()=>{
        cookies.id !== undefined && props.setLoginView(false)
    },[cookies])

    return (<div className="loginPage">
        <div className="loginForm">
            <div className="loginHeader">LOGIN</div>
            <div className="loginBody">
                <input type="text" placeholder="아이디를 입력하세요"/>
                <input type="password" placeholder="비밀번호를 입력하세요"/>
            </div>
            <div className="loginFooter">
                <div className="btnLogin btn" onClick={() => {
                    const inputId = document.querySelectorAll('.loginBody>input')[0].value;
                    const inputPw = document.querySelectorAll('.loginBody>input')[1].value;

                    ( inputId === user[0] && inputPw === user[1] ) && setCookie('id',inputId)
                }}>로그인
                </div>
                <div className="btnCancel btn" onClick={() => {
                    props.setLoginView(false)
                }}>닫 기
                </div>
            </div>
        </div>
    </div>)
}