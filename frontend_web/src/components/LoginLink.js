import React from "react"
import { useAuth0 } from "@auth0/auth0-react"
import styled from "styled-components"

const Login = styled.a`
	position: fixed;
	top: 4rem;
	right: 5rem;
	font-size: 2rem;
	opacity: 0.85;
	text-decoration: none;

	:hover {
		cursor: pointer;
		color: var(--c4);
	}

	@media (max-width: 1300px) {
		right: 3.5rem;
	}

	@media (max-width: 1050px) {
		right: 2rem;
	}

	@media (max-width: 950px) {
		display: none;
	}
`

function LoginLink() {
	const { isAuthenticated, loginWithRedirect } = useAuth0()

	return !isAuthenticated && <Login onClick={loginWithRedirect}>Log in</Login>
}

export default LoginLink
