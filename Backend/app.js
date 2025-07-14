const express = require("express");
const app = express();

const user_model = require("./user_model");


app.get("/", (req, res) => {
    res.send("HEY");
});

app.get("/create", async (req, res) => {
    let created_user = await user_model.create({
        name: "String",
        username: "String",
        email: "String",
    });

    res.send(created_user);
});


app.listen(9999);