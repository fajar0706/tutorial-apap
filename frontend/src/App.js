import React from "react";

import Switch from "react-switch";
import List from "./components/List";
import EmptyState from "./components/EmptyState";
import listMovies from "movies.json";
import "./App.css";

export default class App extends React.Component {
    constructor(props){
        super(props)
        this.state = { 
          favItems : [], 
          show : true 
        };
        this.handleToggle = this.handleToggle.bind(this)
    }

    handleToggle = () => {
        const {show} = this.state;
        this.setState({show : !show});
      }    

    handleItemClick = (item) =>{
        const newItems = [ ...this.state.favItems];
        const newItem = { ...item};
        const targetInd = newItems.findIndex((it)=> it.id === newItem.id);

        if(targetInd < 0) newItems.push(newItem);
        else newItems.splice(targetInd,1);

        this.setState({favItems: newItems});
    };
    handleAddItemClick = (item) =>{
        const newItems = [ ...this.state.favItems];
        const newItem = { ...item};
        const targetInd = newItems.findIndex((it)=> it.id === newItem.id);

        if(targetInd < 0) newItems.push(newItem);

        this.setState({favItems: newItems});
    };
    removeAll = () => {
        this.setState({favItems: []});
    };
    handleToggle = () => {
        const {show} = this.state;
        this.setState({show : !show});
    };

    render() {
        const { favItems } = this.state;
        return (
            <div className="container-fluid">
                <h1 className="text-center mt-3 mb-0">Favorites Movie App</h1>
                <p className="text-center text-secondary text-sm font-italic">
                    (This is a <strong>class-based</strong> application)
                </p>
                <br></br>
                <div><button type="button" class="btn btn-danger float-right" onClick={this.removeAll}>Delete All Favorites</button></div>
                <br>
                </br>
                <br></br>
                <div className="text-left"><h2> Show Favorite</h2></div>

                <div className="container pt-3 ">
                    <label className="switch ">
                        <input type="checkbox" onChange={this.handleToggle}/>
                        <span className="slider round"></span>
                    </label>
                    <div className="row">
                        <div className="col-sm">
                            <List
                                title="List Movies"
                                items={listMovies}
                                onItemClick={this.handleAddItemClick}
                            />
                        </div>
                        {!this.state.show ? 
                        <div className="col-sm">
                            {!this.state.favItems.length ? <EmptyState/>:
                            <List
                                title="My Favorites"
                                items={favItems}
                                onItemClick={this.handleItemClick}
                            />}
                        </div>
                        : null}
                    </div>
                </div>
            </div>
        );
    }
}

