import React from "react";
import classes from "./styles.module.css";

const Pagination = ({total, perPage, paginate}) => {
    const pageNumbers = [];
    for (let i=1; i<= Math.ceil(total / perPage); i++){
        pageNumbers.push(i);
    }

    return (
        <nav aria-label="Page navigation example">
            <ul>
                {pageNumbers.map(number => (
                    <button className={classes.button2} onClick={() => paginate(number)}>{number}</button>
                ))}
            </ul>
        </nav>
    )
}

export default Pagination;
