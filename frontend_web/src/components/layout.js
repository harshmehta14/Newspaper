import * as React from "react"

// styling
import styled from "styled-components"
import "../components/styles/global.css"
import Nav from "./nav"
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
`

const Header2 = styled.h2`
	font-size: 2rem;
	position: relative;
	text-align: center;
	margin-top: -2rem;
	background: var(--c3);
	z-index: 1;

	::before,
	::after {
		display: block;
		content: " ";
		width: 42rem;
		height: 0.15rem;
		background-color: var(--c2);
		position: absolute;
		opacity: 0.75;
		top: 1rem;
	}

	::before {
		left: 0;
	}

	::after {
		right: 0;
	}
`

const Layout = ({ children }) => {
	return (
		<>
			<Container>
				<Header>Daily newspaper</Header>
				<Header2>Random content here</Header2>
				<Nav />
				<main>{children}</main>
			</Container>
		</>
	)
}

export default Layout
