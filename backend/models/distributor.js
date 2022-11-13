const mongoose = require('mongoose')

const users_schema = new mongoose.Schema({
  name: {
    type: String,
    required: true
  },
  email: {
    type: String,
    required: true,
    unique:true
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


// const paperboy_schema = new mongoose.Schema({
//   name: {
//     type: String,
//     required: true
//   },
//   email: {
//     type: String,
//     required: true
//   },
//   phno: {
//     type: String,
//     required: true
//   },
//   address: {
//     type: String,
//     required: true
//   },
//   dob:{
//     type: Date,
//   },
//   signup_date: {
//     type: Date,
//     required: true,
//     default: Date.now
//   },
//   stop:{
//     type:Boolean,
//     default:false,
//   },
//   distributor:{
//     type:String,
//   }
// })

const distributor_schema = new mongoose.Schema({
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
    
  }
})

// module.exports = mongoose.model('users', users_schema)
// module.exports = mongoose.model('paperboy', paperboy_schema)
module.exports = mongoose.model('distributor', distributor_schema)