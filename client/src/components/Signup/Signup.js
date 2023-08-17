import { Container } from './Signup.styled';
import SignUpExplanation from './SignUpExplanation/SignUpExplanation';
import SignupForm from './SignupForm/SignupForm';

function Signup() {
  return (
    <Container>
      <SignUpExplanation />
      <SignupForm />
    </Container>
  );
}
export default Signup;
