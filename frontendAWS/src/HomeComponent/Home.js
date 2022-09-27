import react from "react";

import '../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import img1 from './images/caraousal01.jpg'
import img2 from './images/carousal02.jpg'
import img3 from './images/carousal03.jpg'
import img4 from './images/carousal04.jpg'
import './Carousal.css'
import CardBar from "./CardBar";
import NavBar from "./NavBar";
import VideoComponent from "../Videos/VideoComponent";
import ListNoticeComponent from "../NoticeComponent/ListNoticeComponent";
import Calender from "./Calender";
const Home = () => {
  return (
    <>

      <div className="col-12 mx-auto shadow">
        <div id="carouselExampleIndicators" className="carousel slide" data-bs-ride="carousel">
          <div className="carousel-indicators">
            <a role="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></a>
            <a role="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></a>
            <a role="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></a>
            <a role="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="3" aria-label="Slide 4"></a>
          </div>
          <div className="carousel-inner">
            <div className="carousel-item active">
              <img src={img1} className="d-block w-100 h-100" alt="img1" />
            </div>
            <div className="carousel-item">
              <img src={img2} className="d-block w-100 h-100" alt="img2" />
            </div>
            <div className="carousel-item">
              <img src={img3} className="d-block w-100 h-100" alt="img3" />
            </div>
            <div className="carousel-item">
              <img src={img4} className="d-block w-100 h-100" alt="img4" />
            </div>
          </div>
          <a class="carousel-control-prev" role="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
          </a>
          <a class="carousel-control-next" role="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
          </a>

        </div>

      </div>
      <div>
        <div class="leftdiv">
          <VideoComponent />
        </div>
        <div class='rightdiv'>
          <ListNoticeComponent></ListNoticeComponent>
        </div>
      </div>
      <div>
      </div>


    </>


  );
};
export default Home;