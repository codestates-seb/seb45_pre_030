import { useState } from 'react';
import {
  Head,
  StyledLink,
  Nav,
  StyledNav,
  FontW,
  QuestionInput,
} from './Header.styled';
import userData from '../data/db';

function Header() {
  // 로그인 on/off
  const [login] = useState(false);

  return (
    <>
      <Head>
        <StyledLink to="/" style={{ textDecoration: 'none' }}>
          {/* <Logo /> */}
          stack<FontW>overflow</FontW>
        </StyledLink>
        <QuestionInput type="text" placeholder="Search..." />
        <Nav>{login === true ? <LoginSuccess /> : <Loginfail />}</Nav>
      </Head>
    </>
  );
}

// LoginSuccess
function LoginSuccess() {
  return <>{userData[0].username}님</>;
}

// Loginfail
function Loginfail() {
  return (
    <>
      <StyledNav to="/login" style={{ textDecoration: 'none' }}>
        Login
      </StyledNav>
      <StyledNav to="/signup" style={{ textDecoration: 'none' }}>
        Signup
      </StyledNav>
    </>
  );
}

export default Header;
