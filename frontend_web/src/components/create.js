import React, { useState } from "react"

export default function Create() {
	const [form, setForm] = useState({
		name: "",
		email: "",
		phno: "",
		address: "",
		collection:"users",
	})

	// These methods will update the state properties.
	function updateForm(value) {
		return setForm((prev) => {
			return { ...prev, ...value }
		})
	}

	// This function will handle the submission.
	async function onSubmit(e) {
		e.preventDefault()

		const newPerson = { ...form ,collection:"users"}
		console.log(newPerson)
		await fetch("https://node-backend.harshmehta13.repl.co/", {
			method: "POST",
			headers: {
				"Content-Type": "application/json",
			},
			body: JSON.stringify(newPerson),
		}).catch((error) => {
			window.alert(error)
			return
		})

		setForm({ name: "", email: "", phno: "", address: "" ,collection:"users"})
	}

	return (
		<div>
			<h3>Create a new entry</h3>
			<form onSubmit={onSubmit}>
				<div>
					<label htmlFor="name">Name</label><br></br>
					<input
						type="text"
						id="name"
						value={form.name}
						onChange={(e) => updateForm({ name: e.target.value })}
					/>
				</div>
				<br></br>
				<div>
					<label htmlFor="email">Email address</label><br></br>
					<input
						type="text"
						id="position"
						value={form.email}
						onChange={(e) => updateForm({ email: e.target.value })}
					/>
				</div>
				<br></br>
				<div>
					<label htmlFor="phone number">Phone Number</label><br></br>
					<input
						type="text"
						id="phno"
						value={form.phno}
						onChange={(e) => updateForm({ phno: e.target.value })}
					/>
				</div>
				<br></br>
				<div>
					<label htmlFor="address">Address</label><br></br>
					<input
						type="text"
						id="address"
						value={form.address}
						onChange={(e) =>
							updateForm({ address: e.target.value })
						}
					/>
				</div>
				<br></br>
				

				<div className="form-group">
					<input
						type="submit"
						value="Create person"
						className="btn btn-primary"
					/>
				</div>
			</form>
		</div>
	)
}
