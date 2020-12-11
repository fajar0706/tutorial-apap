import React from "react";
import Button from "../Button";
import Kamar from "../Kamar";
import classes from "./styles.module.css";


const Hotel = (props) => {
    const {id, namaHotel, alamat, nomorTelepon,handleEdit, handleDelete, listKamar} = props;

return (
    <div className={classes.hotel}>
        <h3>{`ID Hotel ${id}`}</h3>
        <p>{`Nama Hotel: ${namaHotel}`}</p>
        <p>{`Alamat: ${alamat}`}</p>
        <p>{`Nomor telepon: ${nomorTelepon}`}</p>
        <div>
            <p className={classes.bold}>List Kamar: </p>
            {listKamar.length !==0 ?(
                <div>
                    {listKamar.map((kamar) => (
                        <Kamar
                        key={kamar.id} 
                        namaKamar={kamar.namaKamar} 
                        kapasitasKamar={kamar.kapasitasKamar} />
                    ))}
                </div>
            ): <p className={classes.bold}>Hotel tidak memiliki Kamar</p>}
        </div>
        <Button onClick={handleEdit} variant="success">
        Edit
        </Button>
        <Button onClick={handleDelete} variant="danger">
        Delete
        </Button>
    </div>
    );
};

export default Hotel;
