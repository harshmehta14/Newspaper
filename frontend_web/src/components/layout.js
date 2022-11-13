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
		width: 30%;
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
			width: 25%;
		}
	}

	@media (max-width: 850px) {
		::before,
		::after {
			width: 20%;
		}
	}

  @media (max-width: 700px){
    ::before, ::after{
      width: 12%;
    }
  }
`

const Days = ["Monday", "Tuesday", "Wednesday","Thursday","Friday","Saturday", "Sunday"]
const Months =  ["January","February","March","April","May","June","July",
            "August","September","October","November","December"]

const date = new Date()

const Layout = ({ children }) => {
	return (
		<>
			<LoginLink />
			<LogoutLink />
			<Container>
				<Header>
					<Link to="/">Kabootar Newspaper</Link>
				</Header>
				<Header2>
          {Days[date.getDay()]}, {Months[date.getMonth()]} {date.getDate()},
					{date.getFullYear()}
				</Header2>
				<Nav />
				<main>{children}</main>
			</Container>
		</>
	)
}

export default Layout
