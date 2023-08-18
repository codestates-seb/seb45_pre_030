import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import {
  From,
  Head,
  Label,
  Input,
  Button,
  EmailText,
  PwText,
} from './Signup.styled';

function Signup() {
  const navigate = useNavigate();

  // 이름, 이메일, 비밀번호, 확인비밀번호 저장
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');

  // 오류텍스트 상태저장
  const [emailText, setEmailText] = useState('');
  const [passwordText, setPasswordText] = useState('');

  // 이름 저장
  const onNameHandler = (e) => {
    setName(e.target.value);
  };

  // 이메일 정규식
  const emailRegEx =
    /^[A-Za-z0-9]([-_.]?[A-Za-z0-9])*@[A-Za-z0-9]([-_.]?[A-Za-z0-9])*\.[A-Za-z]{2,3}$/i;

  // 사용자가 입력한 값 저장하는 곳
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
  const onConfirmPasswordHandler = (e) => {
    setConfirmPassword(e.target.value);
  };

  const onSubmitHandler = () => {
    // 만약 비밀번호가 안맞으면 설명글 보이기
    if (name === '') {
      alert('이름을 입력해 주세요.');
    } else if (email === '') {
      alert('이메일을 입력해 주세요.');
    } else if (password === '') {
      alert('비밀번호를 입력해 주세요.');
    } else if (password === confirmPassword) {
      alert('회원가입 성공!');
      console.log('비밀번호가 일치합니다.');
      setPasswordText('none');

      // 메인 페이지로 이동
      navigate('/');
    } else {
      setPasswordText('null');
    }
  };

  return (
    <From>
      <Head>회원가입</Head>

      {/* 이름 입력 */}
      <Label>이름</Label>
      <Input type="text" placeholder="이름 입력" onChange={onNameHandler} />

      {/* 이메일 형식인지 확인 */}
      <Label>이메일</Label>
      <Input type="email" placeholder="이메일 입력" onChange={onEmailHandler} />
      <EmailText emailText={emailText}>
        이메일 형식이 아닙니다. 다시 입력해 주세요
      </EmailText>

      {/* 비밀번호 일치/불일치 확인 */}
      <Label>비밀번호</Label>
      <Input
        type="password"
        placeholder="비밀번호 입력"
        onChange={onPasswordHandler}
      />

      <Label>비밀번호 확인</Label>
      <Input
        type="password"
        placeholder="비밀번호 재입력"
        onChange={onConfirmPasswordHandler}
      />
      <PwText passwordText={passwordText}>
        동일한 비밀번호를 입력해주세요
      </PwText>

      <Button type="submit" onClick={onSubmitHandler}>
        회원가입
      </Button>
    </From>
  );
}

export default Signup;
