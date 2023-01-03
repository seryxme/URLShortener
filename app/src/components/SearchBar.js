import React from "react";
import Button from "react-bootstrap/Button";
import "bootstrap/dist/css/bootstrap.min.css";
import "./SearchBar.css";
import { useState } from "react";

// const getShortUrlHandler = () => {
  //   const [data, setData] = useState(null);
  //   const [loading, setLoading] = useState(true);
  //   const [error, setError] = useState(null);
  //   useEffect(() => {
  //     async function fetchData() {
  //       try {
  //         const response = await fetch("http://localhost:9000/shortenURL", {
  //           method: "POST",
  //         });
  //         const data = await response.json();
  //         setData(data);
  //       } catch (error) {
  //         setError(error);
  //       } finally {
  //         setLoading(false);
  //       }
  //     }
  //     fetchData();
  //   }, []);
  //   if (loading) {
  //     return <div>Loading...</div>;
  //   }
  //   if (error) {
  //     return <div>An error occurred: {error.message}</div>;
  //   }
  //   return (
  //     <div>
  //       <h1>Data from the API:</h1>
  //       {data.map((item) => (
  //         <div key={item.id}>{item.name}</div>
  //       ))}
  //     </div>
  //   );
// };

const SearchBar = ({setShortUrl}) => {
  const [longUrl, setLongUrl] = useState("");

  const urlSubmitHandler = async (event) => {
    event.preventDefault();
    await fetch("shortenURL", {
      method: "POST",
      body: JSON.stringify({
        longURL: longUrl,
      }),
      headers: {
        "Content-type": "application/json; charset=UTF-8",
      },
    })
      .then((response) => response.json())
      .then((json) => {
        setShortUrl(json)
      });
  };

  return (
    <form onSubmit={urlSubmitHandler}>
      <div className="url-box">
        <h2>Enter the URL you want to shorten:</h2>

        <input
          type="text"
          className="form-control"
          placeholder="Enter URL to shorten"
          value={longUrl}
          onChange={(e) => {
            setLongUrl(e.target.value);
          }}
        />
        <div className="d-grid gap-2">
          <Button
            type="submit"
            className="btn btn-primary"
          >
            Get Short URL
          </Button>
        </div>
      </div>
    </form>
  );
};

export default SearchBar;
