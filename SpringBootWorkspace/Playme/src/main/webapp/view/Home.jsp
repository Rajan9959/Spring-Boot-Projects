<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>

<style>
*{
    background-color: black;
}
a{
    text-decoration: none;
}
#home
{
    font-size: 20px;
    color: white;
    font-weight: bold;
}
#l1{
    position: relative;
    left: 100px;
    bottom: 40px;
    background: transparent;
}
#l1 a{
	text-decoration: none;
}
.hordiv{
   background-color: black;
   margin-left: 1000px;
   position: fixed;
}
.logo{
    color: white;
    font-size: 25px;
    font-weight: 600;
}
li{
    list-style: none;
}
.b1,.b2{
    background:transparent;
    border-radius: 10px;
    padding: 5px;
    width: 80px;
}
button a{
    color: green;
    font-weight: bold;
    font-size: 15px;
    text-decoration: none;
    outline: none;
    background: transparent;
}
.vernav{
    position: fixed;
    display: block;
    height: 500px;
    width: 300px;
    align-content: center;
}
.createplaylist,.createpodcasts{
    color: white;
    background-color: rgb(36, 35, 35);
    border-radius: 5px;
    height: 100px;
    text-align: center;
    line-height: 20px;
    position: relative;
    bottom: 10px;
    padding-bottom: 5px;
}
.createplaylist h4,.createpodcasts h4{
	background: transparent;
    position: relative;
    top: 15px;
    font-size: 15px;
}
.b3,.b4
{
    height: 30px;
    width: 200px;
    border-radius: 10px;
    border: none;
    background-color: white;
    font-weight: bold;
    font-size: 1rem;
    position: relative;
    top: 20px;	
}
.text{
	position: relative;
	top: -3px;
}
.text a{
    color: white;
    padding-left: 5px;
    margin-right: 20px;
    line-height: 40px;
    text-decoration: none;
}
.library{
    color: white;
    width: 200px;
    height: 40px;
    margin-left: 40px;
    border-radius: 10px;
    border: none;
    background-color: rgb(36, 35, 35);
    justify-content: space-evenly;
}
.library a{
    color: white;
    background: transparent;
}
.b5{
    margin-left: 50px;
    width: 200px;
    height: 30px;
    border-radius: 10px;
    border: none;
    font-size: 1rem;
    font-weight: bold;
    background-color: white;
    position: relative;
}
.artist{
    color: white;
    position: absolute;
    translate: 360px 20px;
    border-bottom: dotted;
    border-color: grey;
}
.artist img{
    height: 160px;
    border-radius: 10px;
}
.albums{
    color: white;
    position: absolute;
    translate: 360px 300px;
    border-bottom: dotted;
    border-color: grey;
}
.albums img{
    height: 160px;
    width: 124px;
    border-radius: 10px;
}
.radio{
    color: white;
    position: absolute;
    translate: 360px 580px;
    border-bottom: dotted;
    border-color: grey;
}
.radio img{
    height: 160px;
    width: 124px;
    border-radius: 10px;
}
.charts{
    color: white;
    position: absolute;
    translate: 360px 860px;
    border-bottom: dotted;
    border-color: grey;
}
.charts img{
    height: 160px;
    width: 124px;
    border-radius: 10px;
}
.spotify{
    color: white;
    position: absolute;
    translate: 360px 1140px;
    border-bottom: dotted;
    border-color: grey;
}
.spotify img{
    height: 160px;
    width: 124px;
    border-radius: 10px;
}
.episodes{
    color: white;
    position: absolute;
    translate: 360px 1420px;
    border-bottom: dotted;
    border-color: grey;
}
.episodes img{
    height: 160px;
    width: 124px;
    border-radius: 10px;
}
.last{
    color: white;
    line-height: 25px;
    display: flex;
    margin-left: 300px;
    position: relative;
    top: 1700px;
}
.li5{
    font-size: 50px;
    position: relative;
    top: -20px;
}
.last ul h3{
    border-bottom: ridge;
    width: max-content;
}
.last ul a{
    color: white;
    text-decoration: none;
}
.hordiv button:hover{
    filter: drop-shadow(5px 5px 20px yellow);
}
.s1,.b{
	background-color: white;
}
</style>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
             integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" 
             crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>
	<nav class="vernav">
        <div class="logo"><i class="fa-solid fa-music"></i>PlayMe</div>
        <ul>
            <li id="l1"><a href="#" id="home"><i class="fa-solid fa-house-chimney"></i>Home</a></li>
            <li>
                <form class="search">
                    <input class="s1" type="search" placeholder="Search">
                    <button class="b" type="submit">Search</button>
                </form>
            </li>
        </ul>
        <button class="library"><i class="fa-solid fa-bars"></i><a href="#">Your Library</a><i class="fa-solid fa-plus"></i></button>

        <div class="createplaylist">
            <h4>Create your first playlist</h4>
            <button class="b3">Create playlist</button>
        </div>

        <div class="createpodcasts">
            <h4>Let's find some podcasts to follow</h4>
            <button class="b4">Browse podcasts</button>
        </div>
        <div class="text">
            <a href="#">Legal</a>
            <a href="#">Safety and PrivacyCenter</a><br>
            <a href="#">PrivacyPolicy</a>
            <a href="#">Cookies</a>
            <a href="#">AboutAds</a><br>
            <a href="#">Accessibility</a>
        </div>
        <button class="b5"><i class="fa-solid fa-globe"></i>English</button>
    </nav>
    <div class="hordiv">
        <button class="b1"><a href="#">SignUp</a></button>
        <button class="b2"><a href="#">LogIn</a></button>
    </div> 
    <div class="artist">
        <h3>Popular artists</h3>
        <a href="#"><img src="https://th.bing.com/th/id/OIP.2UZeLHI4mgiJCf1vOu53lwHaJz?w=139&h=184&c=7&r=0&o=5&dpr=1.5&pid=1.7"></a>
        <h5>Rahul Sipligunj</h5>
    </div>
    <div class="albums">
        <h3>Popular albums</h3>
        <a href="#"><img src="https://th.bing.com/th?id=OIP._WtPpAnmBQEbJbT8w_n57gHaLe&w=200&h=311&c=8&rs=1&qlt=90&o=6&dpr=1.5&pid=3.1&rm=2"></a>
        <h5>Pushpa 2</h5>
    </div>
    <div class="radio">
        <h3>Popular radio</h3>
        <a href="#"><img src="https://i.ibb.co/ZKhPpMC/Cover2.jpg"></a>
        <h5>Arijit Singh radio</h5>
    </div>
    <div class="charts">
        <h3>Featured charts</h3>
        <a href="#"><img src="https://kaze.wiki/images/thumb/7/7b/Top_Songs_Global_%C2%B7_September_23_-_29%2C_2022.jpg/640px-Top_Songs_Global_%C2%B7_September_23_-_29%2C_2022.jpg"></a>
        <h5>Top songs</h5>
    </div>
    <div class="spotify">
        <h3>Spotify playlists</h3>
        <a href="#"><img src="https://th.bing.com/th/id/OIP.-W41LrejwqMbc6s19Cz6EQHaHa?rs=1&pid=ImgDetMain"></a>
        <h5>Hip-Hop</h5>
    </div>
    <div class="episodes">
        <h3>Trending episodes</h3>
        <a href="#"><img src="https://th.bing.com/th/id/OIP.FsC2qXGW0QnTZJhzAMXimQHaHa?rs=1&pid=ImgDetMain"></a>
        <h5>Anubis</h5>
    </div>
    <div class="last">
        <ul class="li1">
            <h3>Company</h3>
            <li><a href="#">About</a></li>
            <li><a href="#">Jobs</a></li>
            <li><a href="#">For the Record</a></li>
        </ul>
        <ul class="li2">
            <h3>Communities</h3>
            <li><a href="#">For Artists</a></li>
            <li><a href="#">Developers</a></li>
            <li><a href="#">Advertising</a></li>
            <li><a href="#">Investors</a></li>
            <li><a href="#">Vendors</a></li>
        </ul>
        <ul class="li3">
            <h3>Useful links</h3>
            <li><a href="#">Support</a></li>
            <li><a href="#">Free Mobile</a></li>
            <li><a href="#">App</a></li>
        </ul>
        <ul class="li4">
            <h3>Spotify Plans</h3>
            <li><a href="#">Premium Individual</a></li>
            <li><a href="#">Premium Duo</a></li>
            <li><a href="#">Premium Family</a></li>
            <li><a href="#">Premium Student</a></li>
            <li><a href="#">Spotify Free</a></li>
        </ul>
        <ul class="li5">
            <a href="#"><i class="fa-brands fa-instagram"></i></a>
            <a href="#"><i class="fa-brands fa-twitter"></i></a>
        </ul>
    </div>
</body>
</html>