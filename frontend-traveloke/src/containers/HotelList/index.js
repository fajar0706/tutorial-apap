import React, { Component } from "react";
import APIConfig from "../../api/APIConfig";
import Button from "../../components/Button";
import Hotel from "../../components/Hotel";
import Modal from "../../components/Model";
import Pagination from "../../components/Pagination";
import classes from "./styles.module.css";

class HotelList extends Component {

constructor(props){
    super(props);
    this.state = {
        hotels: [],
        // {
        // id: 1,
        // namaHotel: "Hotel Papa",
        // alamat: "Depok",
        // nomorTelepon: "08211234",
        // },
        // {
        // id: 2,
        // namaHotel: "Hotel Mama",
        // alamat: "Jekardah",
        // nomorTelepon: "08211234",
        // },
        // {
        // id: 3,
        // namaHotel: "Hotel Dede",
        // alamat: "Thepok",
        // nomorTelepon: "08211234",
        // }
        // ],
        isLoading: false,
        isCreate: false,
        isEdit: false,
        namaHotel: "",
        alamat: "",
        nomorTelepon: "",
        currPage:1,
        perPage:5,
    };
    this.handleClickLoading = this.handleClickLoading.bind(this);
    this.handleAddHotel = this.handleAddHotel.bind(this);
    this.handleCancel = this.handleCancel.bind(this);
    this.handleChangeField = this.handleChangeField.bind(this);
    this.handleSubmitAddHotel = this.handleSubmitAddHotel.bind(this);
    this.handleEditHotel = this.handleEditHotel.bind(this);
    this.handleSubmitEditHotel = this.handleSubmitEditHotel.bind(this);
    this.handleDeleteHotel = this.handleDeleteHotel.bind(this);
}
componentDidMount() {
    // console.log("componentDidMount()");
    this.loadData();
}

handleCancel(event) {
    event.preventDefault();
    this.setState({ isCreate: false, isEdit: false, namaHotel: "",alamat: "",nomorTelepon: "" });
}

handleEditHotel(hotel) {
    this.setState({
    isEdit: true,
    id: hotel.id,
    namaHotel: hotel.namaHotel,
    alamat: hotel.alamat,
    nomorTelepon: hotel.nomorTelepon,
    });
}    

async loadData(){
    try {
        const { data } = await APIConfig.get("/hotels");
        this.setState({ hotels: data });
    }catch (error) {
        alert("Oops terjadi masalah pada server");
        console.log(error);
    }
}
async handleSubmitAddHotel(event) {
    event.preventDefault();
    try {
        const data = {
        namaHotel: this.state.namaHotel,
        alamat: this.state.alamat,
        nomorTelepon: this.state.nomorTelepon,
    };
    await APIConfig.post("/hotel", data);
    this.loadData();
    } catch (error) {
    alert("Oops terjadi masalah pada server");
    console.log(error);
    }
    this.handleCancel(event);
}
async handleSubmitEditHotel(event) {
    event.preventDefault();
    try {
        const data = {
        namaHotel: this.state.namaHotel,
        alamat: this.state.alamat,
        nomorTelepon: this.state.nomorTelepon,
    };
    await APIConfig.put(`/hotel/${this.state.id}`, data);
    this.loadData();
    } catch (error) {
    alert("Oops terjadi masalah pada server");
    console.log(error);
    }
    this.handleCancel(event);
}

async handleDeleteHotel(id) {
    try {
        await APIConfig.delete(`/hotel/${id}`);
        this.loadData();
    } catch (error) {
    alert("Hallo!! Hotel ini memiliki Kamar, jadi kamu tidak dapat menghapusnya");
    console.log(error);
    }
}

handleAddHotel() {
    this.setState({ isCreate: true });
}

// shouldComponentUpdate(nextProps, nextState) {
//     console.log("shouldComponentUpdate()");
//     return this.state.isLoading
// }

handleChangeField(event) {
    const { name, value } = event.target;
    this.setState({ [name]: value });
}
    
handleClickLoading() {
    const currentLoading = this.state.isLoading;
    this.setState({ isLoading: !currentLoading });
    console.log(this.state.isLoading);
}


handleSearch = event => {
    const name = event.target.value;
    this.inputSearch(name);
}

async inputSearch(name){
    const fetchedHotels = [];
    const response = await APIConfig.get("/hotels");
    for (let key in response.data){
        if (response.data[key].namaHotel.toLowerCase().startsWith(name.toLowerCase())){
            fetchedHotels.push({
                ...response.data[key]
            });
        }
    }
    this.setState({
        hotels : fetchedHotels
    });
}

render() {
    // console.log("render()")
    const lastIndex = this.state.currPage*this.state.perPage;
    const firstIndex = lastIndex - this.state.perPage;
    const hotelPage = this.state.hotels.slice(firstIndex,lastIndex);
    const paginate = (pageNumber) =>this.setState({currPage:pageNumber})

    return (
        <div className={classes.hotelList}>
            <h1 className={classes.title}>All Hotels</h1>
            <Button onClick={this.handleAddHotel} variant="primary">
                + Add Hotel
            </Button>
            <div>
            <div className={classes.SearchLayout}>
                <input className={classes.SearchBar} onChange={this.handleSearch} type="text" placeholder="Search..." aria-label="Search"/>
            </div>
            <div>
                {this.state.hotels && hotelPage.map((hotel) => (
                <Hotel
                    key={hotel.id}
                    id={hotel.id}
                    namaHotel={hotel.namaHotel}
                    alamat={hotel.alamat}
                    nomorTelepon={hotel.nomorTelepon}
                    listKamar= {hotel.listKamar}
                    handleEdit={() => this.handleEditHotel(hotel)}
                    handleDelete={() => this.handleDeleteHotel(hotel.id)}
                />
                ))}
            </div>
            <div className={classes.PaginationLayout}>
                <Pagination total={this.state.hotels.length} perPage={this.state.perPage} paginate={paginate}/>
            </div>
            </div>
            <Modal show={this.state.isCreate || this.state.isEdit} handleCloseModal={this.handleCancel}>
                <form>
                    <h3 className={classes.modalTitle}>
                        {this.state.isCreate
                        ? "Add Hotel"
                        : `Edit Hotel Nomor ${this.state.id}`}
                    </h3>
                    <input
                        className={classes.textField}
                        type="text"
                        placeholder="Nama Hotel"
                        name="namaHotel"
                        value={this.state.namaHotel}
                        onChange={this.handleChangeField}
                    />
                    <input
                        className={classes.textField}
                        type="text"
                        placeholder="Alamat"
                        name="alamat"
                        value={this.state.alamat}
                        onChange={this.handleChangeField}
                    />
                    <textarea
                        className={classes.textField}
                        placeholder="Nomor Telepon"
                        name="nomorTelepon"
                        rows="4"
                        value={this.state.nomorTelepon}
                        onChange={this.handleChangeField}
                    />
                    <Button onClick={this.state.isCreate
                            ? this.handleSubmitAddHotel
                            : this.handleSubmitEditHotel
                            } variant="primary">
                        {this.state.isCreate ? "Create" : "Edit"}
                    </Button>
                    <Button onClick={this.handleCancel} variant="danger">
                            Cancel
                    </Button>
                </form>
            </Modal>
        </div>
        );

    }    
}

export default HotelList;