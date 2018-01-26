package robosNoPlato;

import static org.junit.Assert.*;


import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class Testes_RoboNoPlato {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@Rule
    public TemporaryFolder folder = new TemporaryFolder();
	
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}
	
	@Test
	public void testEntradaValida() throws IOException {
		final File file = folder.newFile("someTestFile.txt");
		String path = file.toPath().toString();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	    bw.write("5 5\n1 2 N\nEAEAEAEAA\n3 3 L\nAADAADADDA");
	    bw.close();
	   
		Main m = new Main();
		m.run(path);
		
		assertEquals("1 3 N\n5 1 L\n", outContent.toString());
	}

	@Test
	public void testEntradaInvalidaDimensaoCampo1() throws IOException {
		final File file = folder.newFile("someTestFile.txt");
		String path = file.toPath().toString();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	    bw.write("5.5 5\n1 2 N\nEAEAEAEAA\n3 3 L\nAADAADADDA");
	    bw.close();
	   
		Main m = new Main();
		m.run(path);
		
		assertEquals("Entrada inválida\n", outContent.toString());
	}
	
	@Test
	public void testEntradaInvalidaDimensaoCampo2() throws IOException {
		final File file = folder.newFile("someTestFile.txt");
		String path = file.toPath().toString();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	    bw.write("A5 5\n1 2 N\nEAEAEAEAA\n3 3 L\nAADAADADDA");
	    bw.close();
	   
		Main m = new Main();
		m.run(path);
		
		assertEquals("Entrada inválida\n", outContent.toString());
	}
	
	@Test
	public void testEntradaInvalidaDimensaoCampo3() throws IOException {
		final File file = folder.newFile("someTestFile.txt");
		String path = file.toPath().toString();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	    bw.write("5 5t\n1 2 N\nEAEAEAEAA\n3 3 L\nAADAADADDA");
	    bw.close();
	   
		Main m = new Main();
		m.run(path);
		
		assertEquals("Entrada inválida\n", outContent.toString());
	}
	
	@Test
	public void testEntradaInvalidaDimensaoCampo4() throws IOException {
		final File file = folder.newFile("someTestFile.txt");
		String path = file.toPath().toString();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	    bw.write("55\n1 2 N\nEAEAEAEAA\n3 3 L\nAADAADADDA");
	    bw.close();
	   
		Main m = new Main();
		m.run(path);
		
		assertEquals("Entrada inválida\n", outContent.toString());
	}
	
	@Test
	public void testEntradaInvalidaDisposicaoRobo1() throws IOException {
		final File file = folder.newFile("someTestFile.txt");
		String path = file.toPath().toString();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	    bw.write("5 5\n12 N\nEAEAEAEAA\n3 3 L\nAADAADADDA");
	    bw.close();
	   
		Main m = new Main();
		m.run(path);
		
		assertEquals("Entrada inválida\n", outContent.toString());
	}
	
	@Test
	public void testEntradaInvalidaDisposicaoRobo2() throws IOException {
		final File file = folder.newFile("someTestFile.txt");
		String path = file.toPath().toString();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	    bw.write("5 5\n1 2 \nEAEAEAEAA\n3 3 L\nAADAADADDA");
	    bw.close();
	   
		Main m = new Main();
		m.run(path);
		
		assertEquals("Entrada inválida\n", outContent.toString());
	}
	
	@Test
	public void testEntradaInvalidaDisposicaoRobo3() throws IOException {
		final File file = folder.newFile("someTestFile.txt");
		String path = file.toPath().toString();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	    bw.write("5 5\na1 2 N\nEAEAEAEAA\n3 3 L\nAADAADADDA");
	    bw.close();
	   
		Main m = new Main();
		m.run(path);
		
		assertEquals("Entrada inválida\n", outContent.toString());
	}
	
	@Test
	public void testEntradaInvalidaDisposicaoRobo4() throws IOException {
		final File file = folder.newFile("someTestFile.txt");
		String path = file.toPath().toString();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	    bw.write("5 5\n1 2 N L\nEAEAEAEAA\n3 3 L\nAADAADADDA");
	    bw.close();
	   
		Main m = new Main();
		m.run(path);
		
		assertEquals("Entrada inválida\n", outContent.toString());
	}
	
	@Test
	public void testEntradaInvalidaInicioMaiorQueDimensaoPlato1() throws IOException {
		final File file = folder.newFile("someTestFile.txt");
		String path = file.toPath().toString();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	    bw.write("5 5\na7 7 N\nEAEAEAEAA\n3 3 L\nAADAADADDA");
	    bw.close();
	   
		Main m = new Main();
		m.run(path);
		
		assertEquals("Entrada inválida\n", outContent.toString());
	}
	
	@Test
	public void testEntradaInvalidaInicioMaiorQueDimensaoPlato2() throws IOException {
		final File file = folder.newFile("someTestFile.txt");
		String path = file.toPath().toString();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	    bw.write("5 5\na7 1 N\nEAEAEAEAA\n3 3 L\nAADAADADDA");
	    bw.close();
	   
		Main m = new Main();
		m.run(path);
		
		assertEquals("Entrada inválida\n", outContent.toString());
	}
	
	@Test
	public void testEntradaInvalidaInicioMaiorQueDimensaoPlato3() throws IOException {
		final File file = folder.newFile("someTestFile.txt");
		String path = file.toPath().toString();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	    bw.write("5 5\na1 7 N\nEAEAEAEAA\n3 3 L\nAADAADADDA");
	    bw.close();
	   
		Main m = new Main();
		m.run(path);
		
		assertEquals("Entrada inválida\n", outContent.toString());
	}
	
	@Test
	public void testEntradaInvalidaLetrasErradas1() throws IOException {
		final File file = folder.newFile("someTestFile.txt");
		String path = file.toPath().toString();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	    bw.write("5 5\n1 7 K\nEAEAEAEAA\n3 3 L\nAADAADADDA");
	    bw.close();
	   
		Main m = new Main();
		m.run(path);
		
		assertEquals("Entrada inválida\n", outContent.toString());
	}
	
	@Test
	public void testEntradaInvalidaLetrasErradas2() throws IOException {
		final File file = folder.newFile("someTestFile.txt");
		String path = file.toPath().toString();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	    bw.write("5 5\n1 7 N\nLAEAEAEAA\n3 3 L\nAADAADADDA");
	    bw.close();
	   
		Main m = new Main();
		m.run(path);
		
		assertEquals("Entrada inválida\n", outContent.toString());
	}
	
	@Test
	public void testEntradaInvalidaLetrasErradas3() throws IOException {
		final File file = folder.newFile("someTestFile.txt");
		String path = file.toPath().toString();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	    bw.write("5 5\n1 7 N\nAEAEAEAA2\n3 3 L\nAADAADADDA");
	    bw.close();
	   
		Main m = new Main();
		m.run(path);
		
		assertEquals("Entrada inválida\n", outContent.toString());
	}

	@Test
	public void testArquivoErrado() throws IOException {
		final File file = folder.newFile("someTestFile.txt");
		String path = file.toPath().toString();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	    bw.write("5 5\n1 7 N\nLAEAEAEAA\n3 3 L\nAADAADADDA");
	    bw.close();
	   
		Main m = new Main();
		m.run("someTestFile.txt");
		
		assertEquals("Arquivo não encontrado\n", outContent.toString());
	}
	
	@After
	public void restoreStreams() {
	    System.setOut(System.out);
	    System.setErr(System.err);
	}
}
