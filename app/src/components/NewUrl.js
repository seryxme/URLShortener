import React from "react";

const NewUrl = (props) => {
    return (
        <div>
            <h2>Your short URL is: {props.newUrl}</h2>
        </div>
    );
};

export default NewUrl;