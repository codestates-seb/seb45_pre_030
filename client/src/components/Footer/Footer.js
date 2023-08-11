import { Container, LogoContainer, Logo, FooterNav } from './Footer.styled';
import LogoSrc from '../../common/image/icon.png';
import StackOverflow from './FooterStack';
import Products from './FooterProducts';
import Company from './FooterCompany';
import Network from './FooterNetwork';
import Copyright from './FooterCopyright';
function Footer() {
  return (
    <Container>
      <LogoContainer>
        <Logo src={LogoSrc} />
      </LogoContainer>
      <FooterNav>
        <StackOverflow />
        <Products />
        <Company />
        <Network />
      </FooterNav>
      <Copyright />
    </Container>
  );
}

export default Footer;
