import React from "react";
import Button from "react-bootstrap/Button";
import "bootstrap/dist/css/bootstrap.min.css";
import "./NewUrl.css"

const NewUrl = (props) => {
    const copyText = () => {
        const url = props.newUrl
        return navigator.clipboard.writeText(url);
    }
    return (
        <div>
            <div className="url-box">
                <h2>Your short URL:</h2>
                <input
                    type='text'
                    className="form-control"
                    placeholder='Your shortened URL will be here'
                    id='shortUrl'
                    value={props.newUrl}
                />
                <div className="d-grid gap-2">
                    <Button
                        className="btn btn-primary"
                        onClick={copyText}
                    >
                        Copy Short URL
                    </Button>
                </div>
            </div>
            {/*<h2>Your short URL is: {props.newUrl}</h2>*/}
        </div>
    );
};

export default NewUrl;