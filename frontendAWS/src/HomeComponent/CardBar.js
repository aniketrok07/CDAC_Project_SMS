
import React from "react";
import ListNoticeComponent from "../NoticeComponent/ListNoticeComponent";
import './Carousal.css'
const CardBar = () => {
    return (
        <div className="container-fluid nav-bg">
            <div className="row">

                <div className="cardbar">

                    <div className="innercard">We don't stop going to school when we graduate. - Carol Burnett</div>
                </div>
                <div className="cardbar2">
                    <ListNoticeComponent />
                </div>
            </div></div>
    );
};
export default CardBar;