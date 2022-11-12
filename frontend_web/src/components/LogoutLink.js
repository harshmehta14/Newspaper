import React from "react"
import { useAuth0 } from "@auth0/auth0-react"
import styled from "styled-components"

const Logout = styled.a`
	position: fixed;
	top: 4rem;
	right: 5rem;
	font-size: 2rem;
	opacity: 0.85;

	:hover {
		cursor: pointer;
		color: var(--c4);
	}
`

function LogoutLink() {
	const { isAuthenticated, logout } = useAuth0()

	return (
		isAuthenticated && (
			<Logout
				onClick={() => {
					logout({ returnTo: window.location.origin })
				}}>
				Log out
			</Logout>
		)
	)
}

export default LogoutLink
