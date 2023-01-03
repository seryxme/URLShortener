import React, { useState } from "react";
import SearchBar from "./SearchBar";
import "./Home.css";
import NewUrl from "./NewUrl";

const Home = () => {
  const [shortUrl, setShortUrl] = useState({});
  return (
    <div>
        <h1>MyURL.com</h1>
        <SearchBar setShortUrl = {setShortUrl}/>
        <NewUrl newUrl = {shortUrl.shortURL}/>
    </div>
  );
};

export default Home;
