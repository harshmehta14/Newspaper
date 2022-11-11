import * as React from "react"
import styled from "styled-components"
import { useState } from "react"
import { Link } from "gatsby"
import { bar, ham } from "../components/styles/nav.module.css"

const Pagelinks = styled.nav`
	padding: 0.7rem 1rem;
	background-color: var(--c1);
	display: flex;
	align-items: center;
	justify-content: flex-start;
	gap: 3rem;
	ul {
		margin: 0;
		display: flex;
		justify-content: space-between;
		align-items: center;
		list-style: none;
		padding: 0;
	}

	ul a {
		text-decoration: none;
		color: var(--c3);
		font-size: 1.3rem;
		font-weight: 700;
	}
`

export default function Nav() {
	const [toggle, setToggle] = useState(false)

	const handleToggle = () => {
		setToggle(!toggle)
	}

	return (
		<Pagelinks>
			<div
				className={ham}
				role="navigation">
				<span className={bar}></span>
				<span className={bar}></span>
				<span className={bar}></span>
			</div>
			<ul>
				<li>
					<Link to="/">random link</Link>
				</li>
				<li>
					<Link to="/">random link 2</Link>
				</li>
			</ul>
		</Pagelinks>
	)
}
