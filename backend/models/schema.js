const mongoose = require('mongoose')

const users = new mongoose.Schema({
  name: {
    type: String,
    required: true
  },
  email: {
    type: String,
    required: true
  },
  phno: {
    type: String,
    required: true
  },
  address: {
    type: String,
    required: true
  },
  items: {
    type: Object,
  },
  signup_date: {
    type: Date,
    required: true,
    default: Date.now
  },
  stop:{
    type:Boolean,
    default:false,
  }
})


const paperboy = new mongoose.Schema({
  name: {
    type: String,
    required: true
  },
  email: {
    type: String,
    required: true
  },
  phno: {
    type: String,
    required: true
  },
  address: {
    type: String,
    required: true
  },
  dob:{
    type: Date,
  },
  signup_date: {
    type: Date,
    required: true,
    default: Date.now
  },
  stop:{
    type:Boolean,
    default:false,
  },
  distributor:{
    type:String,
  }
})

const distributor = new mongoose.Schema({
  name: {
    type: String,
    required: true
  },
  email: {
    type: String,
    required: true
  },
  phno: {
    type: String,
    required: true
  },
  address: {
    type: String,
    required: true
  },
  signup_date: {
    type: Date,
    required: true,
    default: Date.now
  },
  newspaper_variety:{
    type:Array,
    default:false,
  }
})

module.exports = mongoose.model('users', users)
module.exports = mongoose.model('paperboy', paperboy)
module.exports = mongoose.model('distributor', distributor)