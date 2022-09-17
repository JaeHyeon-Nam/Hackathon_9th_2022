/* global kakao */
import {useState, useEffect, useRef} from "react";
import '../styles/Map.scss'
import Apply from "./Apply";

export default function Map(props) {
    const [kakaoMap, setKakaoMap] = useState(null);
    const [cartView, setCartView] = useState(true);
    const [userPtr, setUserPtr] = useState([36.661808,127.50278849999998])
    const [getNow, setGetNow] = useState(false)
    const [focusPtr,setFocusPtr] = useState(userPtr)

    let positions = [
        {
            title: '카카오',
            latlng: new kakao.maps.LatLng(33.450705, 126.570677)
        },
        {
            title: '생태연못',
            latlng: new kakao.maps.LatLng(33.450936, 126.569477)
        },
        {
            title: '텃밭',
            latlng: new kakao.maps.LatLng(33.450879, 126.569940)
        },
        {
            title: '근린공원',
            latlng: new kakao.maps.LatLng(33.451393, 126.570738)
        }
    ];

    positions.forEach((p,index)=>{
        const marker = new kakao.maps.Marker({
            map: kakaoMap,
            position: p.latlng,
            title : p.title,
        })
        kakao.maps.event.addListener(marker, 'click', (e)=>{

            const geocoder = new kakao.maps.services.Geocoder()
            // 마커 위에 인포윈도우를 표시합니다
            const lat = marker.getPosition().getLat()
            const lon = marker.getPosition().getLng()

            geocoder.coord2RegionCode(lon, lat, (result)=>{
                console.log(result[0].address_name)
            })

            document.querySelector('.cartBox').classList.toggle('active')
        })
    })


    useEffect(() => {
        document.querySelector('.cartBox').classList.toggle('active')
    }, [cartView])

    useEffect(() => {
        navigator.geolocation.getCurrentPosition(function (position) {
                setUserPtr([position.coords.latitude, position.coords.longitude])
                initMap();
            }
        )
    }, [getNow])


    const initMap = () => {
        const container = document.querySelector('#map')
        const center = new kakao.maps.LatLng(focusPtr[0], focusPtr[1]);
        const options = {
            center,
            level: 5,
        };
        const map = new kakao.maps.Map(container, options);
        setKakaoMap(map);
    };

    useEffect(() => {
        initMap();
    }, []);

    const markerPosition = new kakao.maps.LatLng(focusPtr[0], focusPtr[1]);

    const marker = new kakao.maps.Marker({
        position: markerPosition
    });

    marker.setMap(kakaoMap);

    var iwContent = '<div style="padding:5px;">Hello World! <br><a href="https://map.kakao.com/link/map/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
        iwPosition = new kakao.maps.LatLng(33.450701, 126.570667); //인포윈도우 표시 위치입니다

// 인포윈도우를 생성합니다
    var infowindow = new kakao.maps.InfoWindow({
        position: iwPosition,
        content: iwContent
    });

// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
    infowindow.open(kakaoMap, marker);

    const [applyView,setApplyView] = useState(false)

    return (
        <div className="mapPage">
            {
                applyView && <Apply setApplyView={setApplyView}></Apply>
            }
            {
                kakao.maps.event.addListener(marker, 'click', (e)=>{

                    const geocoder = new kakao.maps.services.Geocoder()
                    // 마커 위에 인포윈도우를 표시합니다
                    const lat = marker.getPosition().getLat()
                    const lon = marker.getPosition().getLng()

                    geocoder.coord2RegionCode(lon, lat, (result)=>{
                        console.log(result[0].address_name)
                    })

                    document.querySelector('.cartBox').classList.toggle('active')
                })
            }
            <div id="map">
                <div className="btnBox">
                    <div className="btnNow btn" onClick={() => {
                        setGetNow(!getNow)
                    }}>내 위치
                    </div>
                    <div className="btnCancel btn" onClick={()=>{
                        props.setMapView(false)
                    }}>닫 기</div>
                </div>
                <div className="cartBox">
                    <div className="cartToggle material-symbols-outlined" onClick={() => {
                        setCartView(!cartView)
                    }}>
                        {
                            cartView ? "keyboard_double_arrow_left" :
                                "keyboard_double_arrow_right"
                        }
                    </div>
                    <div className="cartList">
                        <div className="contentInfo">
                            <p className="contentTitle">관광지 이름</p>
                            <p className="contentAbout">관광지 상세</p>
                        </div>
                        <div className="contentApplyList">
                            <div className="contentApply">
                                <p>서포터</p>
                                <p>황진경</p>
                                <p>2022-09-17</p>
                                <div className="btnJoin">신청</div>
                            </div>
                            <div className="contentApply">
                                <p>장애인</p>
                                <p>황진경</p>
                                <p>2022-09-17</p>
                                <div className="btnJoin">신청</div>
                            </div>
                            <div className="contentApply">

                            </div>
                            <div className="contentApply">

                            </div>
                            <div className="contentApply">

                            </div>
                            <div className="contentApply">

                            </div>
                            <div className="contentApply">

                            </div>
                        </div>
                        <div className="contentBtnBox">
                            <div className="btn btnApply" onClick={()=>{
                                setApplyView(!applyView)
                            }}>등 록</div>
                            <div className="btn btnCancel" onClick={()=>{
                                document.querySelector('.cartBox').classList.toggle('active')
                            }}>닫 기</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}