import { useState } from 'react';
import userData from '../data/db';
import { useNavigate } from 'react-router-dom';
import { From, Head, Label, Input, Button, StyledNav } from './Login.styled';

function Login() {
  const navigate = useNavigate();

  // 이메일, 비밀번호 저장
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const onEmailHandler = (e) => {
    setEmail(e.target.value);
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
    <From>
      <Head>로그인</Head>

      <Label>이메일</Label>
      <Input
        type="email"
        placeholder="이메일을 입력"
        onChange={onEmailHandler}
      />

      <Label>비밀번호</Label>
      <Input
        type="password"
        placeholder="비밀번호 입력"
        onChange={onPasswordHandler}
      />

      <Button type="submit" onClick={onSubmitHandler}>
        로그인
      </Button>
      <StyledNav to="/signup" style={{ textDecoration: 'none' }}>
        회원가입
      </StyledNav>
    </From>
  );
}

export default Login;
