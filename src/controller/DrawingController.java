package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import shapes.Observer;

import javax.lang.model.element.Element;
import javax.security.auth.login.FailedLoginException;
import javax.swing.DefaultListModel;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import adapter.HexagonAdapter;
import commands.CmdAddShape;
import commands.CmdBringToBack;
import commands.CmdBringToFront;
import commands.CmdDeleteAll;
import commands.CmdDeleteShape;
import commands.CmdToBack;
import commands.CmdToFront;
import commands.CmdUpdateCircle;
import commands.CmdUpdateHexagon;
import commands.CmdUpdateLine;
import commands.CmdUpdatePoint;
import commands.CmdUpdateRectangle;
import commands.CmdUpdateSquare;
import dialogs.DlgAddCircle;
import dialogs.DlgAddHexagon;
import dialogs.DlgAddRectangle;
import dialogs.DlgAddSquare;
import dialogs.DlgLine;
import dialogs.DlgModifyCircle;
import dialogs.DlgModifyHexagon;
import dialogs.DlgModifyRectangle;
import dialogs.DlgModifySquare;
import dialogs.DlgPoint;
import frame.DrawingFrame;
import hexagon.Hexagon;
import model.DrawingModel;
import shapes.Circle;
import shapes.Command;
import shapes.Line;
import shapes.Point;
import shapes.Rectangle;
import shapes.Shape;
import shapes.Square;
import shapes.Subject;
import strategy.Context;
import strategy.FileLog;
import strategy.FileSerialization;
import view.DrawingView;

public class DrawingController implements Subject {

	private DrawingModel model;
	private DrawingFrame frame;
	private String tglBtn;
	private int numClick;
	private Point startP;
	private String btn;
	private int numberOfSelectedShapes;
	private ArrayList<Observer> observers;
	private Stack<Command> undoCommands;
	private Stack<Command> redoCommands;
	private DefaultListModel<String> log;
	private Context context;
	private FileLog fileLog;

	public DrawingController(DrawingModel model, DrawingFrame frame) {
		this.model = model;
		this.frame = frame;
		this.observers = new ArrayList<Observer>();
		this.undoCommands = new Stack<Command>();
		this.redoCommands = new Stack<Command>();
		log = frame.getDlmLogList();

	}

	public void mouseClicked(MouseEvent arg0) {
		if (tglBtn != null) {
			CmdAddShape shape;
			if (tglBtn.equals("Point")) {
				Point point = new Point(arg0.getX(), arg0.getY(), frame.getBtnEdgeColor().getBackground());
				shape = new CmdAddShape(point, model);
				doCommand(shape);
				log.addElement(shape.getCommandLog());

			} else if (tglBtn.equals("Line")) {
				if (numClick == 0) {
					startP = new Point(arg0.getX(), arg0.getY());
					numClick = 1;
				} else {
					Point endP = new Point(arg0.getX(), arg0.getY());
					Line line = new Line(startP, endP, frame.getBtnEdgeColor().getBackground());
					numClick = 0;
					shape = new CmdAddShape(line, model);
					doCommand(shape);
					log.addElement(shape.getCommandLog());
				}
			} else if (tglBtn.equals("Square")) {
				DlgAddSquare dlgAddSquare = new DlgAddSquare();
				dlgAddSquare.setVisible(true);
				if (dlgAddSquare.isCanceled()) {
					log.addElement("Adding square canceled");
				} else {
					Square square = new Square(new Point(arg0.getX(), arg0.getY()), dlgAddSquare.getSide(),
							frame.getBtnEdgeColor().getBackground(), frame.getBtnAreaColor().getBackground());
					if (dlgAddSquare.getSide() > 0) {
						shape = new CmdAddShape(square, model);
						doCommand(shape);
						log.addElement(shape.getCommandLog());
					} else if (dlgAddSquare.getSide() < 0) {
						JOptionPane.showMessageDialog(null, "Value can't be negative", "Warning",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			} else if (tglBtn.equals("Rectangle")) {
				DlgAddRectangle dlgAddRectangle = new DlgAddRectangle();
				dlgAddRectangle.setVisible(true);
				if (dlgAddRectangle.isCanceled()) {
					log.addElement("Adding rectangle canceled");
				} else {
					Rectangle rectangle = new Rectangle(new Point(arg0.getX(), arg0.getY()),
							dlgAddRectangle.getHeightRec(), dlgAddRectangle.getWidthRec(),
							frame.getBtnEdgeColor().getBackground(), frame.getBtnAreaColor().getBackground());
					if (dlgAddRectangle.getHeightRec() > 0 && dlgAddRectangle.getWidthRec() > 0) {
						shape = new CmdAddShape(rectangle, model);
						doCommand(shape);
						log.addElement(shape.getCommandLog());
					} else if (dlgAddRectangle.getHeightRec() <= 0 || dlgAddRectangle.getWidthRec() <= 0)
						JOptionPane.showMessageDialog(null, "Value can't be negative", "Warning",
								JOptionPane.ERROR_MESSAGE);
				}
			} else if (tglBtn.equals("Circle")) {
				DlgAddCircle dlgAddCircle = new DlgAddCircle();
				dlgAddCircle.setVisible(true);
				if (dlgAddCircle.isCanceled()) {
					log.addElement("Adding circle canceled");
				} else {
					Circle circle = new Circle(dlgAddCircle.getRadius(), new Point(arg0.getX(), arg0.getY()),
							frame.getBtnEdgeColor().getBackground(), frame.getBtnAreaColor().getBackground());
					if (dlgAddCircle.getRadius() > 0) {
						shape = new CmdAddShape(circle, model);
						doCommand(shape);
						log.addElement(shape.getCommandLog());
					} else if (dlgAddCircle.getRadius() <= 0)
						JOptionPane.showMessageDialog(null, "Value can't be negative", "Warning",
								JOptionPane.ERROR_MESSAGE);
				}
			} else if (tglBtn.equals("Hexagon")) {
				DlgAddHexagon dlgAddHexagon = new DlgAddHexagon();
				dlgAddHexagon.setVisible(true);
				if (dlgAddHexagon.isCanceled()) {
					log.addElement("Adding hexagon canceled");
				} else {
					HexagonAdapter hexagonAdapter = new HexagonAdapter(
							new Hexagon(arg0.getX(), arg0.getY(), dlgAddHexagon.getRadius()),
							frame.getBtnEdgeColor().getBackground(), frame.getBtnAreaColor().getBackground());
					if (dlgAddHexagon.getRadius() > 0) {
						shape = new CmdAddShape(hexagonAdapter, model);
						doCommand(shape);
						log.addElement(shape.getCommandLog());
					} else {
						JOptionPane.showMessageDialog(null, "Value can't be negative", "Warning",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			} else if (tglBtn.equals("Select")) {
				// ukoliko smo kliknuli na select i potom kliknuli na ekran, treba da proverimo
				// da li neki od oblika sadrzi tacku klika...ukoliko sadrzi, da ga oznacimo kao
				// selektovanog
				for (int i = this.model.getAll().size() - 1; i >= 0; i--) {
					if (this.model.getAll().get(i).contains(arg0.getX(), arg0.getY())) {
						if (this.model.getAll().get(i).isSelected()) {
							// ukoliko je vec selektovano
							setNumberOfSelectedShapes(getNumberOfSelectedShapes() - 1);
							this.model.getAll().get(i).setSelected(false);
							log.addElement("Deselect_" + model.get(i).toString());
							break;
						} else {
							setNumberOfSelectedShapes(getNumberOfSelectedShapes() + 1);
							this.model.getAll().get(i).setSelected(true);
							log.addElement("Select_" + model.get(i).toString());
							break;
						}
					}
				}
			}
			if(numClick==1 && !tglBtn.equals("Line")){
				numClick=0;
			}
		}
		frame.getView().repaint();
	}

	public void tglBtnClicked(String name) {
		tglBtn = name;
	}

	public void btnClicked(String name) {
		Shape shape;
		Command newShape;
		Command deleteShape;
		Command deleteAll;
		ArrayList<Shape> listOfSelectedShapes = new ArrayList<Shape>();
		Object[] options = { "Yes", "No" };
		int n = 0;

		if (name.equals("Delete")) {
			for (int i = model.getAll().size() - 1; i >= 0; i--) {
				if (model.get(i).isSelected()) {
					listOfSelectedShapes.add(model.get(i));
				}
			}
			if (listOfSelectedShapes.size() == 1) {
				n = JOptionPane.showOptionDialog(null, "Are you sure you want to delete selected shape?",
						"Delete Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
						options[0]);

				if (n == 0) {
					setNumberOfSelectedShapes(getNumberOfSelectedShapes() - 1);
					deleteShape = new CmdDeleteShape(model, listOfSelectedShapes.get(0));
					doCommand(deleteShape);
					System.out.println(((CmdDeleteShape) deleteShape).getCommandLog());
					log.addElement(((CmdDeleteShape) deleteShape).getCommandLog());
				}

			} else if (listOfSelectedShapes.size() > 1) {
				n = JOptionPane.showOptionDialog(null, "Are you sure you want to delete selected shapes?",
						"Delete confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
						options[0]);
				if (n == 0) {
					setNumberOfSelectedShapes(getNumberOfSelectedShapes() - listOfSelectedShapes.size());
					deleteAll = new CmdDeleteAll(listOfSelectedShapes, model);
					doCommand(deleteAll);
					log.addElement(((CmdDeleteAll) deleteAll).getCommandLog());
				}
			}

		}

		for (int i = 0; i < this.model.getAll().size(); i++) {
			if (this.model.get(i).isSelected()) {
				if (name.equals("Modify")) {
					shape = this.model.get(i);
					if (shape instanceof Point) {
						DlgPoint dlgPoint = new DlgPoint();
						dlgPoint.getTxtXCoordinate().setText(((Point) shape).getX() + "");
						dlgPoint.getTxtYCoordinate().setText(((Point) shape).getY() + "");
						dlgPoint.getBtnBorderColor().setBackground(shape.getColor());
						dlgPoint.setVisible(true);
						if (dlgPoint.isCanceled()) {
							log.addElement("Point update canceled");
						} else {
							Point newPoint = new Point(dlgPoint.getxCordModified(), dlgPoint.getyCordModified(),
									dlgPoint.getEdgeColor());
							newShape = new CmdUpdatePoint((Point) shape, newPoint);
							doCommand(newShape);
							model.get(i).setSelected(true);
							log.addElement(((CmdUpdatePoint) newShape).getCommandLog());
						}

					} else if (shape instanceof Line) {
						DlgLine dlgLine = new DlgLine();
						dlgLine.getTxtXCordStartP().setText(((Line) shape).getStartPoint().getX() + "");
						dlgLine.getTxtYCordStartP().setText(((Line) shape).getStartPoint().getY() + "");
						dlgLine.getTxtXCordEndP().setText(((Line) shape).getEndPoint().getX() + "");
						dlgLine.getTxtYCordEndP().setText(((Line) shape).getEndPoint().getY() + "");
						dlgLine.getBtnBorderColor().setBackground(shape.getColor());
						dlgLine.setVisible(true);
						if (dlgLine.isCanceled()) {
							log.addElement("Line update canceled");
						} else {
							Line newLine = new Line(new Point(dlgLine.getxCordStartP(), dlgLine.getyCordStartP()),
									new Point(dlgLine.getxCordEndP(), dlgLine.getyCordEndP()),
									dlgLine.getBorderColor());
							newShape = new CmdUpdateLine((Line) shape, newLine);
							doCommand(newShape);
							model.get(i).setSelected(true);
							log.addElement(((CmdUpdateLine) newShape).getCommandLog());
						}

					} else if (shape instanceof Rectangle) {
						DlgModifyRectangle dlgModifyRectangle = new DlgModifyRectangle();
						dlgModifyRectangle.getTxtXCoordinate().setText(((Rectangle) shape).getUpperLeft().getX() + "");
						dlgModifyRectangle.getTxtYCoordinate().setText(((Rectangle) shape).getUpperLeft().getY() + "");
						dlgModifyRectangle.getTxtHeight().setText(((Rectangle) shape).getPage() + "");
						dlgModifyRectangle.getTxtWidth().setText(((Rectangle) shape).getWidth() + "");
						dlgModifyRectangle.getBtnEdgeColor().setBackground(shape.getColor());
						dlgModifyRectangle.getBtnAreaColor().setBackground(((Rectangle) shape).getColorInside());
						dlgModifyRectangle.setVisible(true);
						if (dlgModifyRectangle.isCanceled()) {
							log.addElement("Rectangle update canceled");
						} else {
							Rectangle newRec = new Rectangle(
									new Point(dlgModifyRectangle.getxCoordinate(), dlgModifyRectangle.getyCoordinate()),
									dlgModifyRectangle.getHeightRec(), dlgModifyRectangle.getWidthRec(),
									dlgModifyRectangle.getEdgeColor(), dlgModifyRectangle.getAreaColor());
							newShape = new CmdUpdateRectangle((Rectangle) shape, newRec);
							doCommand(newShape);
							model.get(i).setSelected(true);
							log.addElement(((CmdUpdateRectangle) newShape).getCommandLog());
						}

					} else if (shape instanceof Square) {
						DlgModifySquare dlgModifySquare = new DlgModifySquare();
						dlgModifySquare.getTxtXCoordinate().setText(((Square) shape).getUpperLeft().getX() + "");
						dlgModifySquare.getTxtYCoordinate().setText(((Square) shape).getUpperLeft().getY() + "");
						dlgModifySquare.getTxtSideLength().setText(((Square) shape).getPage() + "");
						dlgModifySquare.getBtnEdgeColor().setBackground(shape.getColor());
						dlgModifySquare.getBtnAreaColor().setBackground(((Square) shape).getColorInside());
						dlgModifySquare.setVisible(true);
						if (dlgModifySquare.isCanceled()) {
							log.addElement("Square update canceled");
						} else {
							Square newSquare = new Square(
									new Point(dlgModifySquare.getxCoordinate(), dlgModifySquare.getyCoordinate()),
									dlgModifySquare.getSide(), dlgModifySquare.getEdgeColor(),
									dlgModifySquare.getAreaColor());
							newShape = new CmdUpdateSquare((Square) shape, newSquare);
							doCommand(newShape);
							model.get(i).setSelected(true);
							log.addElement(((CmdUpdateSquare) newShape).getCommandLog());
						}

					} else if (shape instanceof Circle) {
						DlgModifyCircle dlgModifyCircle = new DlgModifyCircle();
						dlgModifyCircle.getTxtXCoordinate().setText(((Circle) shape).getCenter().getX() + "");
						dlgModifyCircle.getTxtYCoordinate().setText(((Circle) shape).getCenter().getY() + "");
						dlgModifyCircle.getTxtRadius().setText(((Circle) shape).getRadius() + "");
						dlgModifyCircle.getBtnEdgeColor().setBackground(shape.getColor());
						dlgModifyCircle.getBtnAreaColor().setBackground(((Circle) shape).getColorInside());
						dlgModifyCircle.setVisible(true);
						if (dlgModifyCircle.isCanceled()) {
							log.addElement("Circle update canceled");
						} else {
							Circle newCircle = new Circle(dlgModifyCircle.getRadius(),
									new Point(dlgModifyCircle.getxCoordinate(), dlgModifyCircle.getyCoordinate()),
									dlgModifyCircle.getEdgeColor(), dlgModifyCircle.getAreaColor());
							newShape = new CmdUpdateCircle((Circle) shape, newCircle);
							doCommand(newShape);
							model.get(i).setSelected(true);
							log.addElement(((CmdUpdateCircle) newShape).getCommandLog());

						}

					} else if (shape instanceof HexagonAdapter) {
						DlgModifyHexagon dlgModifyHexagon = new DlgModifyHexagon();
						dlgModifyHexagon.getTxtXCoordinate().setText(((HexagonAdapter) shape).getXCoordinate() + "");
						dlgModifyHexagon.getTxtYCoordinate().setText(((HexagonAdapter) shape).getYCoordinate() + "");
						dlgModifyHexagon.getTxtRadius().setText(((HexagonAdapter) shape).getR() + "");
						dlgModifyHexagon.getBtnEdgeColor().setBackground(((HexagonAdapter) shape).getEdgeColor());
						dlgModifyHexagon.getBtnAreaColor().setBackground(((HexagonAdapter) shape).getAreaColor());
						dlgModifyHexagon.setVisible(true);
						if (dlgModifyHexagon.isCanceled()) {
							log.addElement("Hexagon update canceled");
						} else {
							HexagonAdapter newHexagon = new HexagonAdapter(
									new Point(dlgModifyHexagon.getxCoordinate(), dlgModifyHexagon.getyCoordinate()),
									dlgModifyHexagon.getRadius(), dlgModifyHexagon.getEdgeColor(),
									dlgModifyHexagon.getAreaColor());
							newShape = new CmdUpdateHexagon((HexagonAdapter) shape, newHexagon);
							doCommand(newShape);
							model.get(i).setSelected(true);
							log.addElement(((CmdUpdateHexagon) newShape).getCommandLog());
						}
					}
				}
			}
		}
		frame.getView().repaint();
	}

	public void doCommand(Command c) {

		c.execute();
		undoCommands.add(c);
		notifyObservers(numberOfSelectedShapes, undoCommands.size(), redoCommands.size());

	}

	public Color pickColor(Color oldColor) {
		Color newColor = JColorChooser.showDialog(null, "Pick color", oldColor);
		if (newColor != null) {
			return newColor;
		} else {
			return oldColor;
		}
	}

	public int getNumberOfSelectedShapes() {
		return numberOfSelectedShapes;
	}

	public void setNumberOfSelectedShapes(int numberOfSelectedShapes) {
		this.numberOfSelectedShapes = numberOfSelectedShapes;

		notifyObservers(numberOfSelectedShapes, undoCommands.size(), redoCommands.size());
	}

	@Override
	public void notifyObservers(int selected, int undo, int redo) {

		Iterator<Observer> it = observers.iterator();
		while (it.hasNext()) {
			it.next().update(frame, model, selected, undo, redo);
		}

	}

	@Override
	public void addObserver(Observer o) {
		observers.add(o);

	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);

	}

	public void save() {
		if (!model.getAll().isEmpty()) {
			frame.getjFileChooser().setFileFilter(new FileNameExtensionFilter("SerializeDraw", "ser"));
		}
		if (!log.isEmpty()) {
			frame.getjFileChooser().setFileFilter(new FileNameExtensionFilter("FileLog", "log"));
		}
		if (frame.getjFileChooser().showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			if (frame.getjFileChooser().getFileFilter().getDescription().equals("FileLog"))
				context = new Context(new FileLog(frame, model, this));
			else if (frame.getjFileChooser().getFileFilter().getDescription().equals("SerializeDraw"))
				context = new Context(new FileSerialization(model));

			context.save(frame.getjFileChooser().getSelectedFile());
		}
		frame.getjFileChooser().setVisible(false);
	}

	public void openFile() {
		if (frame.getOpenChooser().showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			model.removeAll();
			log.removeAllElements();
			undoCommands.clear();
			redoCommands.clear();
			notifyObservers(numberOfSelectedShapes, undoCommands.size(), redoCommands.size());

			frame.getView().repaint();

			if (frame.getOpenChooser().getFileFilter().getDescription().equals("SerializeDraw")) {
				context = new Context(new FileSerialization(model));

			} else if (frame.getOpenChooser().getFileFilter().getDescription().equals("FileLog")) {
				fileLog = new FileLog(frame, model, this);
				context = new Context(fileLog);
				frame.getMntmGetLog().setEnabled(true);
			}

			context.open(frame.getOpenChooser().getSelectedFile());
			log.addElement("Imported file from " + frame.getOpenChooser().getSelectedFile().toString());
		}
		frame.getOpenChooser().setVisible(false);
	}

	public void undoRedo(String command) {
		if (command.equals("Undo")) {
			undoCommand();
		} else if (command.equals("Redo")) {
			redoCommand();
		}
		frame.getView().repaint();
	}

	public void undoCommand() {
		Command command = undoCommands.peek();
		command.unexecute();

		if (command instanceof CmdAddShape) {
			if (((CmdAddShape) command).getShape().isSelected()) {
				((CmdAddShape) command).getShape().setSelected(false);
				setNumberOfSelectedShapes(getNumberOfSelectedShapes() - 1);
			}
		} else if (command instanceof CmdDeleteShape) {
			if (((CmdDeleteShape) command).getShape().isSelected()) {
				setNumberOfSelectedShapes(getNumberOfSelectedShapes() + 1);
			}
		}
		if (command instanceof CmdAddShape) {
			log.addElement(((CmdAddShape) command).getCommandLog());
		} else if (command instanceof CmdDeleteShape) {
			log.addElement(((CmdDeleteShape) command).getCommandLog());
		} else if (command instanceof CmdToFront) {
			log.addElement(((CmdToFront) command).getCommandLog());
		} else if (command instanceof CmdToBack) {
			log.addElement(((CmdToBack) command).getCommandLog());
		} else if (command instanceof CmdBringToFront) {
			log.addElement(((CmdBringToFront) command).getCommandLog());
		} else if (command instanceof CmdBringToBack) {
			log.addElement(((CmdBringToBack) command).getCommandLog());
		} else if (command instanceof CmdUpdatePoint) {
			log.addElement(((CmdUpdatePoint) command).getCommandLog());
		} else if (command instanceof CmdUpdateLine) {
			log.addElement(((CmdUpdateLine) command).getCommandLog());
		} else if (command instanceof CmdUpdateRectangle) {
			log.addElement(((CmdUpdateRectangle) command).getCommandLog());
		} else if (command instanceof CmdUpdateSquare) {
			log.addElement(((CmdUpdateSquare) command).getCommandLog());
		} else if (command instanceof CmdUpdateCircle) {
			log.addElement(((CmdUpdateCircle) command).getCommandLog());
		} else if (command instanceof CmdUpdateHexagon) {
			log.addElement(((CmdUpdateHexagon) command).getCommandLog());
		}

		if (command instanceof CmdDeleteAll) {
			log.addElement(((CmdDeleteAll) command).getCommandLog());
			int n = ((CmdDeleteAll) command).getList().size();
			setNumberOfSelectedShapes(getNumberOfSelectedShapes() - n);
		}

		undoCommands.pop();
		notifyObservers(numberOfSelectedShapes, undoCommands.size(), redoCommands.size());
		redoCommands.push(command);
		notifyObservers(numberOfSelectedShapes, undoCommands.size(), redoCommands.size());

	}

	public void redoCommand() {
		Command command = redoCommands.peek();
		command.execute();
		if (command instanceof CmdAddShape) {
			log.addElement(((CmdAddShape) command).getCommandLog());
		} else if (command instanceof CmdDeleteShape) {
			log.addElement(((CmdDeleteShape) command).getCommandLog());
		} else if (command instanceof CmdToFront) {
			log.addElement(((CmdToFront) command).getCommandLog());
		} else if (command instanceof CmdToBack) {
			log.addElement(((CmdToBack) command).getCommandLog());
		} else if (command instanceof CmdBringToFront) {
			log.addElement(((CmdBringToFront) command).getCommandLog());
		} else if (command instanceof CmdBringToBack) {
			log.addElement(((CmdBringToBack) command).getCommandLog());
		} else if (command instanceof CmdUpdatePoint) {
			log.addElement(((CmdUpdatePoint) command).getCommandLog());
		} else if (command instanceof CmdUpdateLine) {
			log.addElement(((CmdUpdateLine) command).getCommandLog());
		} else if (command instanceof CmdUpdateRectangle) {
			log.addElement(((CmdUpdateRectangle) command).getCommandLog());
		} else if (command instanceof CmdUpdateSquare) {
			log.addElement(((CmdUpdateSquare) command).getCommandLog());
		} else if (command instanceof CmdUpdateCircle) {
			log.addElement(((CmdUpdateCircle) command).getCommandLog());
		} else if (command instanceof CmdUpdateHexagon) {
			log.addElement(((CmdUpdateHexagon) command).getCommandLog());
		}
		if (command instanceof CmdDeleteAll) {
			log.addElement(((CmdDeleteAll) command).getCommandLog());
			int n = ((CmdDeleteAll) command).getList().size();
			setNumberOfSelectedShapes(getNumberOfSelectedShapes() - n);
		}
		undoCommands.push(command);
		redoCommands.pop();
		notifyObservers(numberOfSelectedShapes, undoCommands.size(), redoCommands.size());

	}

	public void moveByZAxis(String name) {
		for (int i = model.getAll().size() - 1; i >= 0; i--) {
			if (model.get(i).isSelected()) {
				if (name.equals("To Front")) {
					if (model.getIndexOf(model.get(i)) == model.getAll().size() - 1) {
						JOptionPane.showMessageDialog(null, "Shape is already on top");
					} else {
						CmdToFront cmdToFront = new CmdToFront(model.get(i), model);
						doCommand(cmdToFront);
						log.addElement(cmdToFront.getCommandLog());
					}
				} else if (name.equals("To Back")) {
					if (model.getIndexOf(model.get(i)) == 0) {
						JOptionPane.showMessageDialog(null, "Shape is already at the bottom");
					} else {
						CmdToBack cmdToBack = new CmdToBack(model.get(i), model);
						doCommand(cmdToBack);
						log.addElement(cmdToBack.getCommandLog());
						break;
					}
				} else if (name.equals("Bring To Front")) {
					if (model.getIndexOf(model.get(i)) == model.getAll().size() - 1) {
						JOptionPane.showMessageDialog(null, "Shape is already on top!");
					} else {
						CmdBringToFront cmdBringToFront = new CmdBringToFront(model.get(i), model,
								model.getAll().size() - 1);
						doCommand(cmdBringToFront);
						log.addElement(cmdBringToFront.getCommandLog());
					}
				} else if (name.equals("Bring To Back")) {
					if (model.getIndexOf(model.get(i)) == 0) {
						JOptionPane.showMessageDialog(null, "Shape is already at the bottom");
					} else {
						CmdBringToBack cmdBringToBack = new CmdBringToBack(model.get(i), model);
						doCommand(cmdBringToBack);
						log.addElement(cmdBringToBack.getCommandLog());
						break;

					}
				}
			}
		}
		frame.getView().repaint();

	}

	public DefaultListModel<String> getLog() {
		return log;
	}

	public void setLog(DefaultListModel<String> log) {
		this.log = log;
	}

	public void readCommand() {
		fileLog.getLine();
	}

}
