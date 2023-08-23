import { Container } from './Signup.styled';
import SignUpExplanation from '../SignupExplanation/SignupExplanation';
import SignupForm from '../SignupFrom/SignupFrom';

function Signup() {
  return (
    <Container>
      <SignUpExplanation />
      <SignupForm />
    </Container>
  );
}
export default Signup;
