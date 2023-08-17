import { useState } from 'react';
import userData from '../data/db';
import { useNavigate } from 'react-router-dom';
import {
  From,
  Label,
  Input,
  Button,
  StyledNav,
  EmailText,
  Text,
  Logo,
} from './Login.styled';
import LogoSrc from '/Users/leeseeun/seb45_pre_030/client/src/common/image/icon.png';

function Login() {
  const navigate = useNavigate();

  // 이메일, 비밀번호 저장
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  // 오류텍스트 상태저장
  const [emailText, setEmailText] = useState('');

  // 이메일 정규식
  const emailRegEx =
    /^[A-Za-z0-9]([-_.]?[A-Za-z0-9])*@[A-Za-z0-9]([-_.]?[A-Za-z0-9])*\.[A-Za-z]{2,3}$/i;

  const onEmailHandler = (e) => {
    setEmail(e.target.value);
    // 만약 이메일 형식이 아니면 설명글 보이기
    if (emailRegEx.test(email) === false) {
      setEmailText('null');
    } else {
      setEmailText('none');
    }
  };
  const onPasswordHandler = (e) => {
    setPassword(e.target.value);
  };

  // 로그인 시도
  const onSubmitHandler = () => {
    // 유저 데이터에 있던 정보랑 내가 적은 정보가 같아야 로그인 성공함
    if (
      email === userData[0].useremail &&
      Number(password) === Number(userData[0].pw)
    ) {
      alert('로그인 성공');
      navigate('/');
    } else {
      alert('로그인 실패');
      navigate('/');
    }
  };

  return (
    <>
      <Logo src={LogoSrc} />
      <From>
        <Label>Email</Label>
        <Input
          type="email"
          placeholder="이메일 입력"
          onChange={onEmailHandler}
        />
        <EmailText emailText={emailText}>
          The email is not a valid email address.
        </EmailText>

        <Label>Password</Label>
        <Input
          type="password"
          placeholder="비밀번호 입력"
          onChange={onPasswordHandler}
        />

        <Button type="submit" onClick={onSubmitHandler}>
          Log in
        </Button>
      </From>
      <StyledNav to="/signup" style={{ textDecoration: 'none' }}>
        <Text>Dont have an account? </Text>
        Sign up
      </StyledNav>
    </>
  );
}

export default Login;
