const express = require('express')
const router = express.Router()
const users = require('../models/user_schema')
const paperboy = require('../models/paperboy_schema')
// const distributor = require('../models/schema')



router.get('/', async (req, res) => {
  try {
    const all_users = await users.find()
    res.json(all_users)
  } catch (err) {
    res.status(500).json({ message: err.message })
  }
})


router.get('/paperboy', async (req, res) => {
  try {
    const all_users = await paperboy.find()
    res.json(all_users)
  } catch (err) {
    res.status(500).json({ message: err.message })
  }
})


router.post('/', async (req, res) => {
  const user = new users({
    name: req.body.name,
    email: req.body.email,
    phno:  req.body.phno,
    address:  req.body.address,
  })
  try {
    const newuser = await user.save()
    res.status(201).json(newuser)
  } catch (err) {
    res.status(400).json({ message: err.message })
  }
})


router.post('/paperboy', async (req, res) => {
  const user_paperboy = new paperboy({
    name: req.body.name,
    email: req.body.email,
    phno:  req.body.phno,
    address:  req.body.address,
  })
  try {
    const newuser_paper = await user_paperboy.save()
    res.status(201).json(newuser_paper)
  } catch (err) {
    res.status(400).json({ message: err.message })
  }
})

// router.post('/distributor', async (req, res) => {
//   const user = new distributor({
//     name: req.body.name,
//     email: req.body.email,
//     phno:  req.body.phno,
//     address:  req.body.address,
//   })
//   try {
//     const newuser = await user.save()
//     res.status(201).json(newuser)
//   } catch (err) {
//     res.status(400).json({ message: err.message })
//   }
// })


module.exports = router