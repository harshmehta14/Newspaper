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
`

function LoginLink() {
	const { isAuthenticated } = useAuth0()

	return !isAuthenticated && <Login href="/account">Log in</Login>
}

export default LoginLink
