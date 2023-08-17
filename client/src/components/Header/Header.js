import { useState } from 'react';
import {
  HeaderBox,
  Head,
  StyledLink,
  UserStyledNav,
  Nav,
  StyledNav,
  FontW,
  QuestionInput,
  Bar,
  Logo,
} from './Header.styled';
import userData from '../data/db';
import LogoSrc from '/Users/leeseeun/seb45_pre_030/client/src/common/image/icon.png';

function Header() {
  // 로그인 on/off
  const [login] = useState(true);

  return (
    <HeaderBox>
      <Bar />
      <Head>
        <StyledLink to="/" style={{ textDecoration: 'none' }}>
          <Logo src={LogoSrc} />
          stack<FontW>overflow</FontW>
        </StyledLink>
        <QuestionInput type="text" placeholder="Search..." />
        <Nav>{login === true ? <LoginSuccess /> : <Loginfail />}</Nav>
      </Head>
    </HeaderBox>
  );
}

// LoginSuccess
function LoginSuccess() {
  return (
    <>
      <UserStyledNav to="/profile" style={{ textDecoration: 'none' }}>
        {userData[0].username}
      </UserStyledNav>
      님
    </>
  );
}

// Loginfail
function Loginfail() {
  return (
    <>
      <StyledNav to="/login" style={{ textDecoration: 'none' }}>
        Log in
      </StyledNav>
      <StyledNav to="/signup" style={{ textDecoration: 'none' }}>
        Sign up
      </StyledNav>
    </>
  );
}

export default Header;
