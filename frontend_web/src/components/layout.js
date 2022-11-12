import * as React from "react"

// styling
import styled from "styled-components"
import "../components/styles/global.css"
import Nav from "./nav"
import { Link } from "gatsby"
import LoginLink from "./LoginLink"
import LogoutLink from "./LogoutLink"
// import Footer from "./footer"

const Container = styled.div`
	font-family: var(--f1);
	color: var(--c2);
`
const Header = styled.h1`
	text-align: center;
	font-size: 4rem;
	text-transform: uppercase;
	margin-top: 3rem;

	a {
		text-decoration: none;
		color: inherit;
	}
`

const Header2 = styled.h2`
	font-size: 2rem;
	position: relative;
	text-align: center;
	margin-top: -2rem;
	background: var(--c3);
	z-index: 1;
	opacity: 0.85;

	::before,
	::after {
		display: block;
		content: " ";
		width: 42rem;
		height: 0.15rem;
		background-color: var(--c2);
		position: absolute;
		opacity: 0.7;
		top: 1rem;
	}

	::before {
		left: 0;
	}

	::after {
		right: 0;
	}

	@media (max-width: 1700px) {
		::before,
		::after {
			width: 35rem;
		}
	}

	@media (max-width: 1490px) {
		::before,
		::after {
			width: 30rem;
		}
	}

	@media (max-width: 1320px) {
		::before,
		::after {
			width: 25rem;
		}
	}

	@media (max-width: 1150px) {
		::before,
		::after {
			width: 20rem;
		}
	}

	@media (max-width: 1000px) {
		::before,
		::after {
			width: 15rem;
		}
	}

	@media (max-width: 850px) {
		::before,
		::after {
			width: 10rem;
		}
	}
`

const Days = ["Monday", "", "Sunday"]

const date = new Date()

const Layout = ({ children }) => {
	return (
		<>
			<LoginLink />
			<LogoutLink />
			<Container>
				<Header>
					<Link to="/">Daily newspaper</Link>
				</Header>
				<Header2>
					{date.getDay()},{date.getMonth()} {date.getDate()},
					{date.getFullYear()}
				</Header2>
				<Nav />
				<main>{children}</main>
			</Container>
		</>
	)
}

export default Layout
