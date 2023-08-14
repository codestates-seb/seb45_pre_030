import { Routes, Route } from 'react-router-dom';
import { useState } from 'react';
import Login from '../Login/Login';
import Signup from '../Signup/Signup';
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

      {/* 라우터 */}
      <Routes>
        <Route path="/" element={<div>메인 페이지</div>} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
      </Routes>
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
