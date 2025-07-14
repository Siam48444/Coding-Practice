const express = require("express");
const mongoose = require("mongoose");
const user_model = require("./user_model");

const app = express();

mongoose.connect("mongodb://127.0.0.1:27017/mongodb_practice", {
    useNewUrlParser: true,
    useUnifiedTopology: true
})
.then(() => {
    console.log("✅ MongoDB Connected");
    app.listen(9999);
})
.catch(err => {
    console.error("❌ MongoDB Connection Error:", err);
});

app.get("/", (req, res) => {
    res.send("HEY");
});

app.get("/create", async (req, res) => {
    try {
        const new_user = await user_model.create({
            name: "String",
            username: "String",
            email: "String",
        });
        res.send(new_user);
    } catch (err) {
        res.status(500).send("❌ Error creating user: " + err.message);
    }
});
