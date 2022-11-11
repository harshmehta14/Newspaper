const express = require('express')
const router = express.Router()
const users = require('../models/schema')
const paperboy = require('../models/schema')
const distributor = require('../models/schema')


router.get('/', async (req, res) => {
  try {
    const all_users = await users.find()
    res.json(all_user)
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
    res.status(400).json({ message: "err.message" })
  }
})


router.post('/paperboy', async (req, res) => {
  const user = new paperboy({
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

router.post('/distributor', async (req, res) => {
  const user = new distributor({
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


module.exports = router