import React from "react";
import "./sort.css";


const SortButton = () => {
    const handleSort = async () => {
        const sort = document.getElementById("sortButton")!;
        const value = sort.innerText;
        if (value == "DESC") {
            sort.innerText = "ASC";
        } else {
            sort.innerText = "DESC";
        }
    }


    return (<div id={"value"}>Sort by date
        <button id={"sortButton"} onClick={handleSort}>ASC
        </button>
    </div>)
}
export default SortButton;